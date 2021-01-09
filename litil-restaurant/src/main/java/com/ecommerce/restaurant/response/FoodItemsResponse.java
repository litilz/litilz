package com.ecommerce.restaurant.response;


import com.ecommerce.repos.response.BaseResponse;
import com.ecommerce.restaurant.vo.FoodOrderItemsVO;

import java.util.List;

public class FoodItemsResponse extends BaseResponse {

    List<FoodOrderItemsVO> foodOrderItemsVOList;
    private Long orderId;

    public List<FoodOrderItemsVO> getFoodOrderItemsVOList() {
        return foodOrderItemsVOList;
    }

    public void setFoodOrderItemsVOList(List<FoodOrderItemsVO> foodOrderItemsVOList) {
        this.foodOrderItemsVOList = foodOrderItemsVOList;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
