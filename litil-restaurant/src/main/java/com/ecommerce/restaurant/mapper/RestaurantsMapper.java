package com.ecommerce.restaurant.mapper;

import com.ecommerce.restaurant.entity.RestaurantsEntity;
import com.ecommerce.restaurant.vo.RestaurantsVO;
import org.springframework.beans.BeanUtils;

public class RestaurantsMapper {

    public static void convertRestaurantEntitytoRestaurantVO(RestaurantsEntity restaurantsEntity, RestaurantsVO restaurantsVO) {
        BeanUtils.copyProperties(restaurantsEntity, restaurantsVO);
    }
}
