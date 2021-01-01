package com.ecommerce.restaurant.response;

import com.ecommerce.repos.response.BaseResponse;
import com.ecommerce.restaurant.vo.FoodOrdersVO;

public class FoodOrdersResponse extends BaseResponse {
    private FoodOrdersVO foodOrdersVO;

    public FoodOrdersVO getFoodOrdersVO() {
        return foodOrdersVO;
    }

    public void setFoodOrdersVO(FoodOrdersVO foodOrdersVO) {
        this.foodOrdersVO = foodOrdersVO;
    }
}
