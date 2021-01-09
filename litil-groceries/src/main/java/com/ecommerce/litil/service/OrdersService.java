package com.ecommerce.litil.service;


import com.ecommerce.litil.entity.OrderItemEntity;
import com.ecommerce.litil.entity.OrdersEntity;
import com.ecommerce.litil.entity.ProductEntity;
import com.ecommerce.litil.mapper.OrdersMapper;
import com.ecommerce.litil.mapper.ProductMapper;
import com.ecommerce.litil.repository.*;
import com.ecommerce.litil.request.OrderRequest;
import com.ecommerce.litil.response.OrdersListResponse;
import com.ecommerce.litil.response.OrdersResponse;
import com.ecommerce.litil.vo.OrdersVO;
import com.ecommerce.litil.vo.ProductVO;
import com.ecommerce.repos.entity.AddressEntity;
import com.ecommerce.repos.entity.UserEntity;
import com.ecommerce.repos.exception.LitilException;
import com.ecommerce.litil.entity.CartEntity;
import com.ecommerce.repos.repository.AddressRepository;
import com.ecommerce.repos.repository.UserRepository;
import com.ecommerce.repos.twilio.TwilioService;
import com.ecommerce.repos.util.LitilConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrdersItemRepository ordersItemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MediaOrderRepository mediaOrderRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    TwilioService twilioService;


    Logger logger = LoggerFactory.getLogger(OrdersService.class);

    // Get All User Orders
    public OrdersResponse getAllUserOrders(String user_name) {

        OrdersResponse ordersResponse = new OrdersResponse();
        List<OrdersVO> oVOList = new ArrayList<>();
        UserEntity uEntity = userRepository.getUserByPhoneNumber(user_name);
        List<OrdersEntity> orderList = ordersRepository.findAllUserOrders(uEntity);
        for (OrdersEntity oEntity : orderList) {
            OrdersVO ordersVO = new OrdersVO();
            OrdersMapper.convertOrdersEntitytoOrdersVO(ordersVO, oEntity);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date ordered = oEntity.getDate_ordered();
            ordersVO.setDate_ordered(dateFormat.format(ordered));
            ordersVO.setUser_id(user_name);
            ordersVO.setImage_url("https://litil-products-images.s3.us-east-2.amazonaws.com/Grocery-basket.png");
            AddressEntity aEntity = oEntity.getAddress_id();
            ordersVO.setAddress_id(aEntity.getId());
            oVOList.add(ordersVO);

        }
//        MediaOrderResponse MediaOrderResponse = mediaService.getAllUserMediaOrders(user_name);
//        ordersResponse.setMediaOrdersVO(MediaOrderResponse.getMediaOrdersVO());
        ordersResponse.setOrdersVO(oVOList);
        ordersResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        ordersResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);

        return ordersResponse;
    }


    // Create Order
    public OrdersResponse createOrder(OrderRequest orderRequest) {
        OrdersEntity ordersEntity = new OrdersEntity();
        Long previousTime;
        List<ProductEntity> productList = new ArrayList<>();
        OrdersResponse ordersResponse = new OrdersResponse();
        Date now = new Date();

        synchronized (this) {
            previousTime = System.currentTimeMillis();
        }
        if (orderRequest == null || orderRequest.getOrdersVO() == null) {
            throw new LitilException("Invalid request object");
        }
        orderRequest.getOrdersVO().setId(previousTime);
        orderRequest.getOrdersVO().setStatus(LitilConstants.ORDERED);
        OrdersMapper.convertOrdersVOtoOrdersEntity(orderRequest.getOrdersVO(), ordersEntity);
        AddressEntity aEntity = addressRepository.findById(orderRequest.getOrdersVO().getAddress_id()).get();

        UserEntity uEntity = userRepository.getUserByPhoneNumber(orderRequest.getOrdersVO().getUser_id());
        List<CartEntity> cartList = cartRepository.findAll(uEntity);
        ordersEntity.setUser_id(uEntity);
        ordersEntity.setAddress_id(aEntity);
        ordersEntity.setDate_ordered(now);
        ordersEntity.setId(previousTime);
        ordersEntity.setQuantity(cartList.size());
        ordersRepository.save(ordersEntity);

        List<OrderItemEntity> orderItemEntityList = new ArrayList<>();

        for (CartEntity cList : cartList) {
            OrdersEntity orderEntity = ordersRepository.findById(previousTime).get();
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setOrder_id(orderEntity);
            orderItemEntity.setProduct_id(cList.getProductid());
            orderItemEntity.setQuantity(cList.getQuantity());
            orderItemEntity.setPrice(cList.getPrice());
            orderItemEntityList.add(orderItemEntity);
        }


        ordersItemRepository.saveAll(orderItemEntityList);
        ordersResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        ordersResponse.setStatusDesc(previousTime.toString());
        if (ordersResponse.getStatusCode().equals(LitilConstants.SUCCESS_CODE)) {
            twilioService.sendDetails(orderRequest.getOrdersVO().getUser_id(), "GOid: "+previousTime);
            cartRepository.deleteById(uEntity);
        }
        return ordersResponse;
    }

    // Getting all OrderedProducts
    public OrdersListResponse getOrderedProducts(Long orderId) {
        OrdersListResponse ordersListResponse = new OrdersListResponse();

        List<ProductVO> orderedProductList = new ArrayList<ProductVO>();
        OrdersEntity oEntity = ordersRepository.findById(orderId).get();

        List<OrderItemEntity> orderItems = ordersItemRepository.findAllProducts(oEntity);

        for (OrderItemEntity oList : orderItems) {
            ProductVO productVO = new ProductVO();
            ProductEntity pEntity = oList.getProduct_id();
            ProductMapper.convertProductEnitytoProductVO(productVO, pEntity);
            productVO.setQuantity(oList.getQuantity());
            productVO.setSelling(oList.getPrice().toString());
            orderedProductList.add(productVO);
        }
        ordersListResponse.setOrdersList(orderedProductList);
        ordersListResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        ordersListResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);
        return ordersListResponse;
    }
}
