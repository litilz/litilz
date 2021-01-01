package com.ecommerce.restaurant.service;

import com.ecommerce.repos.entity.UserEntity;
import com.ecommerce.repos.repository.UserRepository;
import com.ecommerce.repos.response.BaseResponse;
import com.ecommerce.repos.util.LitilConstants;
import com.ecommerce.restaurant.entity.FoodCartEntity;
import com.ecommerce.restaurant.entity.ItemsEntity;
import com.ecommerce.restaurant.entity.RestaurantsEntity;
import com.ecommerce.restaurant.mapper.ItemsMapper;
import com.ecommerce.restaurant.repository.FoodCartRepository;
import com.ecommerce.restaurant.repository.ItemsRepository;
import com.ecommerce.restaurant.repository.RestaurantsRepository;
import com.ecommerce.restaurant.response.FoodCartResponse;
import com.ecommerce.restaurant.vo.FoodCartVO;
import com.ecommerce.restaurant.vo.ItemsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;


@Service
public class FoodCartService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    FoodCartRepository foodCartRepository;

    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    RestaurantsRepository restaurantsRepository;

    public BaseResponse createCart(FoodCartVO foodCartVO) {
        BaseResponse baseResponse = new BaseResponse();
        UserEntity uEntity = userRepository.findByUserId(foodCartVO.getUser_name());
        ItemsEntity iEntity = itemsRepository.findById(foodCartVO.getItem_id()).get();
        RestaurantsEntity resEntity = iEntity.getRestaurant_id();
        List<FoodCartEntity> fCEntity = foodCartRepository.findCart(uEntity);
        FoodCartEntity fEntity = new FoodCartEntity();
        if (!CollectionUtils.isEmpty(fCEntity)) {
            fEntity = foodCartRepository.findItem(iEntity, uEntity);
        }
        if (foodCartVO.getIncrement()) {
            if (CollectionUtils.isEmpty(fCEntity)) {
                fEntity.setItem_id(iEntity);
                fEntity.setUser_id(uEntity);
                fEntity.setQuantity(1);
                foodCartRepository.save(fEntity);
            } else if (fEntity != null && fEntity.getItem_id().getRestaurant_id().getName().equals(foodCartVO.getRestaurant_name())) {
                if (fEntity != null) {
                    foodCartRepository.increment(uEntity, iEntity);
                } else {
                    fEntity.setItem_id(iEntity);
                    fEntity.setUser_id(uEntity);
                    fEntity.setQuantity(1);
                    foodCartRepository.save(fEntity);
                }
            } else {
                clearCart(uEntity);
                FoodCartEntity newCart = new FoodCartEntity();
                newCart.setItem_id(iEntity);
                newCart.setUser_id(uEntity);
                newCart.setQuantity(1);
                foodCartRepository.save(newCart);
            }
        } else {
            if (fEntity.getQuantity() == 1) {
                foodCartRepository.deleteById(fEntity.getId());
            } else {
                foodCartRepository.decrement(fEntity.getId());
            }
        }
        baseResponse.setStatusDesc("updated cart successfully");
        return baseResponse;
    }

    public FoodCartResponse getCart(String user_name) {
        FoodCartResponse foodCartResponse = new FoodCartResponse();
        UserEntity uEntity = userRepository.findByUserId(user_name);
        List<FoodCartEntity> foodCartList = foodCartRepository.findCart(uEntity);
        List<ItemsVO> iVO = new LinkedList<>();
        if (!CollectionUtils.isEmpty(foodCartList)) {
            for (FoodCartEntity fCEntity : foodCartList) {
                ItemsVO itemsVO = new ItemsVO();
                if (foodCartResponse.getResEntity() == null) {
                    foodCartResponse.setResEntity(fCEntity.getItem_id().getRestaurant_id());
                    ItemsMapper.convertItemEntitytoItemVO(fCEntity.getItem_id(), itemsVO);
                    itemsVO.setQuantity(fCEntity.getQuantity());
                    iVO.add(itemsVO);
                } else {
                    ItemsMapper.convertItemEntitytoItemVO(fCEntity.getItem_id(), itemsVO);
                    itemsVO.setQuantity(fCEntity.getQuantity());
                    iVO.add(itemsVO);
                }
            }
            foodCartResponse.setItemsVO(iVO);
        } else {
            foodCartResponse.setStatusDesc("No items to display in the cart");
            foodCartResponse.setStatusCode(LitilConstants.FAILURE_CODE);
        }
        return foodCartResponse;
    }


    public void clearCart(UserEntity uEntity) {
        foodCartRepository.clearCart(uEntity);
    }
}
