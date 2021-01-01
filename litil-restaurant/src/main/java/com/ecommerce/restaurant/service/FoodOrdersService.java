package com.ecommerce.restaurant.service;

import com.ecommerce.repos.entity.UserEntity;
import com.ecommerce.repos.repository.UserRepository;
import com.ecommerce.repos.util.LitilConstants;
import com.ecommerce.restaurant.entity.FoodOrdersEntity;
import com.ecommerce.restaurant.mapper.FoodOrdersMapper;
import com.ecommerce.restaurant.repository.FoodOrdersRepository;
import com.ecommerce.restaurant.response.FoodOrdersResponse;
import com.ecommerce.restaurant.vo.FoodOrdersVO;
import com.ecommerce.restaurant.vo.OrderDetailsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

@Service
public class FoodOrdersService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FoodOrdersRepository ordersRepository;

    public void findAllUserOrders(String user_id) {
        FoodOrdersResponse foodOrdersResponse = new FoodOrdersResponse();
        List<FoodOrdersVO> foodOrdersVO = new LinkedList<>();
        UserEntity uEntity = userRepository.findByUserId(user_id);
        List<FoodOrdersEntity> orderEntityList = ordersRepository.findByUser(uEntity);
        List<OrderDetailsVO> oVO = new LinkedList<>();
        FoodOrdersVO fVO = new FoodOrdersVO();
        if (CollectionUtils.isEmpty(orderEntityList)) {
            for (FoodOrdersEntity foodOrdersEntity : orderEntityList) {
                OrderDetailsVO fOVO = new OrderDetailsVO();
                if (CollectionUtils.isEmpty(foodOrdersVO)) {
                    fVO.setResEntity(foodOrdersEntity.getRestaurant_id());
                    FoodOrdersMapper.convertOrdersEntitytoOrdersVO(foodOrdersEntity, fOVO);
                    oVO.add(fOVO);
                } else {
                    FoodOrdersMapper.convertOrdersEntitytoOrdersVO(foodOrdersEntity, fOVO);
                    oVO.add(fOVO);
                }
            }
            foodOrdersResponse.setFoodOrdersVO(fVO);
        } else {
            foodOrdersResponse.setStatusCode(LitilConstants.FAILURE_CODE);
            foodOrdersResponse.setStatusDesc("No Orders to display");
        }
    }
}
