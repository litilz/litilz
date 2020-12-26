package com.ecommerce.restaurant.response;

import com.ecommerce.restaurant.vo.RestaurantsVO;

import java.util.List;

public class RestaurantsResponse {
    List<RestaurantsVO> restaurantsVO;

    public List<RestaurantsVO> getRestaurantsVO() {
        return restaurantsVO;
    }

    public void setRestaurantsVO(List<RestaurantsVO> restaurantsVO) {
        this.restaurantsVO = restaurantsVO;
    }
}
