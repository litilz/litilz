package com.ecommerce.restaurant.service;


import com.ecommerce.repos.entity.AddressEntity;
import com.ecommerce.repos.entity.UserEntity;
import com.ecommerce.repos.exception.LitilException;
import com.ecommerce.repos.repository.AddressRepository;
import com.ecommerce.repos.repository.UserRepository;
import com.ecommerce.repos.response.BaseResponse;
import com.ecommerce.repos.twilio.TwilioService;
import com.ecommerce.repos.util.LitilConstants;
import com.ecommerce.restaurant.entity.FoodCartEntity;
import com.ecommerce.restaurant.entity.FoodOrdersEntity;
import com.ecommerce.restaurant.entity.OrderedFoodItemsEntity;
import com.ecommerce.restaurant.entity.RestaurantsEntity;
import com.ecommerce.restaurant.mapper.FoodOrdersMapper;
import com.ecommerce.restaurant.repository.FoodCartRepository;
import com.ecommerce.restaurant.repository.FoodOrdersRepository;
import com.ecommerce.restaurant.repository.OrderedFoodItemsRepository;
import com.ecommerce.restaurant.repository.RestaurantsRepository;
import com.ecommerce.restaurant.response.FoodItemsResponse;
import com.ecommerce.restaurant.response.FoodOrdersResponse;
import com.ecommerce.restaurant.vo.FoodOrderItemsVO;
import com.ecommerce.restaurant.vo.OrderRequestVO;
import com.ecommerce.restaurant.vo.OrderResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class FoodOrderService {

    @Autowired
    FoodOrdersRepository foodOrdersRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestaurantsRepository restaurantsRepository;

    @Autowired
    OrderedFoodItemsRepository orderedFoodItemsRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    FoodCartRepository foodCartRepository;

    @Autowired
    TwilioService twilioService;


    public BaseResponse placeOrder(OrderRequestVO orderRequestVO) {
        BaseResponse baseResponse = new BaseResponse();
        Date now = new Date();
        Long previousTime;
        UserEntity uEntity = userRepository.findByUserId(orderRequestVO.getUserName());
        RestaurantsEntity rEntity = restaurantsRepository.findRestaurant(orderRequestVO.getRestaurantName());
        AddressEntity aEntity = addressRepository.findById(orderRequestVO.getAddress_id()).get();
        FoodOrdersEntity foodOrdersEntity = new FoodOrdersEntity();
        List<FoodCartEntity> fCartEntity = foodCartRepository.findCart(uEntity);
        FoodOrdersMapper.convertFoodOrdersVOtoFoodOrdersEntity(orderRequestVO, foodOrdersEntity);

        synchronized (this) {
            previousTime = System.currentTimeMillis();
        }

        foodOrdersEntity.setId(previousTime);
        foodOrdersEntity.setAddress_id(aEntity);
        foodOrdersEntity.setUser_id(uEntity);
        foodOrdersEntity.setRestaurant_id(rEntity);
        foodOrdersEntity.setOrdered_items_count(fCartEntity.size());
        foodOrdersEntity.setStatus(LitilConstants.ORDERED);
        foodOrdersEntity.setPayment_mode(LitilConstants.COD);
        foodOrdersEntity.setOrdered_date(now);
        foodOrdersEntity.setGrand_total(orderRequestVO.getGrand_total());
        foodOrdersRepository.save(foodOrdersEntity);

        FoodOrdersEntity foodOrderId = foodOrdersRepository.findById(previousTime).get();
        List<OrderedFoodItemsEntity> orderFoodItemsList = new LinkedList<>();

        for (FoodCartEntity fItemList : fCartEntity) {
            OrderedFoodItemsEntity oItemsEntity = new OrderedFoodItemsEntity();
            oItemsEntity.setOrder_id(foodOrderId);
            oItemsEntity.setItem_id(fItemList.getItem_id());
            oItemsEntity.setItem_quantity(fItemList.getQuantity());
            oItemsEntity.setPrice(fItemList.getItem_id().getPrice());
            orderFoodItemsList.add(oItemsEntity);
        }
        orderedFoodItemsRepository.saveAll(orderFoodItemsList);
        foodCartRepository.clearCart(uEntity);
        baseResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        baseResponse.setStatusDesc(previousTime.toString());
        twilioService.sendDetails(orderRequestVO.getUserName(),"FOid: "+ previousTime);
        return baseResponse;
    }


    public FoodOrdersResponse getAllOrders(String userName) {
        FoodOrdersResponse foodOrdersResponse = new FoodOrdersResponse();
        List<OrderResponseVO> orderResponseVO = new LinkedList<>();
        UserEntity userEntity = userRepository.findByUserId(userName);
        List<FoodOrdersEntity> foodOrdersEntity = foodOrdersRepository.findByUser(userEntity);
        if (foodOrdersEntity.isEmpty()) {
            throw new LitilException("No orders to display");
        } else {
            for (FoodOrdersEntity fOrdersEntity : foodOrdersEntity) {
                OrderResponseVO oVO = new OrderResponseVO();
                FoodOrdersMapper.convertFoodOrdersEntitytoFoodOrdersVO(fOrdersEntity, oVO);
                oVO.setAddressEntity(fOrdersEntity.getAddress_id());
                oVO.setRestaurantName(fOrdersEntity.getRestaurant_id().getName());
                oVO.setUserName(userName);
                orderResponseVO.add(oVO);
            }
            foodOrdersResponse.setOrderResponseVOList(orderResponseVO);
        }
        return foodOrdersResponse;
    }

    public FoodItemsResponse getItems(Long orderId) {
        FoodOrdersEntity foodEntity = foodOrdersRepository.findById(orderId).get();
        List<OrderedFoodItemsEntity> orderedFoodItemsEntityList = orderedFoodItemsRepository.findByOrderId(foodEntity);
        List<FoodOrderItemsVO> foodOrderItemsVOList = new LinkedList<>();
        for (OrderedFoodItemsEntity oFIEntity : orderedFoodItemsEntityList) {
            FoodOrderItemsVO foodOrderItemsVO = new FoodOrderItemsVO();
            foodOrderItemsVO.setImageUrl(oFIEntity.getItem_id().getImage());
            foodOrderItemsVO.setName(oFIEntity.getItem_id().getName());
            foodOrderItemsVO.setItem_quantity(oFIEntity.getItem_quantity());
            foodOrderItemsVO.setPrice(oFIEntity.getPrice());
            foodOrderItemsVOList.add(foodOrderItemsVO);
        }
        FoodItemsResponse FoodItemsResponse = new FoodItemsResponse();
        FoodItemsResponse.setFoodOrderItemsVOList(foodOrderItemsVOList);
        FoodItemsResponse.setObject(orderId);
        return FoodItemsResponse;
    }
}
