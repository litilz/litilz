package com.ecommerce.restaurant.mapper;

import com.ecommerce.restaurant.entity.FoodOrdersEntity;
import com.ecommerce.restaurant.vo.FoodOrdersVO;
import com.ecommerce.restaurant.vo.OrderDetailsVO;
import org.springframework.beans.BeanUtils;

public class FoodOrdersMapper {


    public static void convertOrdersEntitytoOrdersVO(FoodOrdersEntity oEntity, OrderDetailsVO orderDetailsVO) {
        BeanUtils.copyProperties(oEntity, orderDetailsVO);
    }
}
