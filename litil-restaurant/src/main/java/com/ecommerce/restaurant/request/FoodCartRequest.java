package com.ecommerce.restaurant.request;

import com.ecommerce.restaurant.vo.FoodCartVO;

public class FoodCartRequest {

private FoodCartVO foodCartVO;

    public FoodCartVO getFoodCartVO() {
        return foodCartVO;
    }

    public void setFoodCartVO(FoodCartVO foodCartVO) {
        this.foodCartVO = foodCartVO;
    }
}
