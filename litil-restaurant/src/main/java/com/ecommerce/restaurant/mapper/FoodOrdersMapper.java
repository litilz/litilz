package com.ecommerce.restaurant.mapper;

import com.ecommerce.restaurant.entity.FoodOrdersEntity;
import com.ecommerce.restaurant.vo.OrderRequestVO;
import com.ecommerce.restaurant.vo.OrderResponseVO;
import org.springframework.beans.BeanUtils;

public class FoodOrdersMapper {


    public static void convertFoodOrdersVOtoFoodOrdersEntity(OrderRequestVO orderRequestVO, FoodOrdersEntity foodOrdersEntity) {
        BeanUtils.copyProperties(orderRequestVO, foodOrdersEntity);
    }

    public static void convertFoodOrdersEntitytoFoodOrdersVO(FoodOrdersEntity fOrdersEntity, OrderResponseVO oVO) {
        BeanUtils.copyProperties(fOrdersEntity, oVO);
    }
}
