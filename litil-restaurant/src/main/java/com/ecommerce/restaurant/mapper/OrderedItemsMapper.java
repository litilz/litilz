package com.ecommerce.restaurant.mapper;

import com.ecommerce.restaurant.entity.OrderedFoodItemsEntity;
import com.ecommerce.restaurant.vo.FoodOrderItemsVO;
import org.springframework.beans.BeanUtils;

public class OrderedItemsMapper {

    public static void convertOrderItemsEntitytoOrderItemsVO(OrderedFoodItemsEntity oFIEntity, FoodOrderItemsVO foodOrderItemsVO) {
        BeanUtils.copyProperties(oFIEntity, foodOrderItemsVO);
    }
}
