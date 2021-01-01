package com.ecommerce.restaurant.vo;

import com.ecommerce.restaurant.entity.RestaurantsEntity;

public class FoodOrdersVO {

    private OrderDetailsVO orderDetailsVO;
    private RestaurantsEntity resEntity;

    public RestaurantsEntity getResEntity() {
        return resEntity;
    }

    public void setResEntity(RestaurantsEntity resEntity) {
        this.resEntity = resEntity;
    }

    public OrderDetailsVO getOrderDetailsVO() {
        return orderDetailsVO;
    }

    public void setOrderDetailsVO(OrderDetailsVO orderDetailsVO) {
        this.orderDetailsVO = orderDetailsVO;
    }
}
