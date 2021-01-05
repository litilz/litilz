package com.ecommerce.litil.service;


import com.ecommerce.litil.entity.ProductEntity;
import com.ecommerce.litil.repository.CartRepository;
import com.ecommerce.litil.entity.CartEntity;
import com.ecommerce.litil.repository.ProductRepository;
import com.ecommerce.repos.entity.UserEntity;
import com.ecommerce.litil.mapper.ProductMapper;
import com.ecommerce.repos.repository.UserRepository;
import com.ecommerce.repos.response.BaseResponse;
import com.ecommerce.litil.response.CartResponse;
import com.ecommerce.repos.util.LitilConstants;
import com.ecommerce.litil.vo.CartVO;
import com.ecommerce.litil.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartRepository cartRepository;

    public BaseResponse createCart(CartVO cartVO) {
        String desc = "";
        UserEntity userEntity = userRepository.getUserByPhoneNumber(cartVO.getUser_name());
        ProductEntity productEntity = productRepository.findById(cartVO.getProduct()).get();
        CartEntity cartEntity1 = cartRepository.find(userEntity, productEntity);

        if (cartEntity1 != null) {
            if (cartVO.getIncrement()) {
                cartRepository.increment(userEntity, productEntity);
                desc = "successfully incremneted";
            } else {
                if (cartEntity1.getQuantity() == 1) {
                    cartRepository.delete(cartEntity1);
                } else {
                    cartRepository.decrement(userEntity, productEntity);
                }

                desc = "successfully decremented";
            }
        } else {
            CartEntity cartEntity = new CartEntity();
            cartEntity.setUser_id(userEntity);
            cartEntity.setProductid(productEntity);
            cartEntity.setQuantity(1);
            cartEntity.setPrice(Integer.parseInt(productEntity.getSelling()));
            cartRepository.save(cartEntity);
            desc = "successfully saved data";
        }
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        baseResponse.setStatusDesc(desc);
        return baseResponse;
    }

    public CartResponse getCart(String user_name) {

        CartResponse cartResponse = new CartResponse();
        List<ProductVO> productVOList = new ArrayList<>();
        UserEntity userEntity = userRepository.getUserByPhoneNumber(user_name);
        List<CartEntity> cartEntity = cartRepository.findAll(userEntity);

        cartEntity.forEach((c) -> {
            ProductVO productVO = new ProductVO();
            ProductMapper.convertProductEnitytoProductVO(productVO, c.getProductid ());
            productVO.setQuantity(c.getQuantity());
            productVOList.add(productVO);
        });
        cartResponse.setProductVO(productVOList);
        cartResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
        cartResponse.setStatusDesc("found cart for user : " + user_name);
        return cartResponse;
    }

    public void clearCart(String user_name) {
        UserEntity user_id = userRepository.getUserByPhoneNumber(user_name);
        cartRepository.deleteById(user_id);
    }
}
