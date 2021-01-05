package com.ecommerce.litil.mapper;

import com.ecommerce.litil.entity.OrdersEntity;
import com.ecommerce.litil.vo.OrdersVO;
import org.springframework.beans.BeanUtils;

public class OrdersMapper {
    public static void convertOrdersVOtoOrdersEntity(OrdersVO ordersVO, OrdersEntity ordersEntity) {

        BeanUtils.copyProperties(ordersVO, ordersEntity);
    }

    public static void convertOrdersEntitytoOrdersVO(OrdersVO ordersVO, OrdersEntity ordersEntity) {

        BeanUtils.copyProperties(ordersEntity, ordersVO);
    }
}
