package com.ecommerce.restaurant.response;

import com.ecommerce.repos.response.BaseResponse;
import com.ecommerce.restaurant.entity.RestaurantsEntity;
import com.ecommerce.restaurant.vo.ItemsVO;
import com.ecommerce.restaurant.vo.OrderDetailsVO;

import java.util.List;

public class FoodCartResponse extends BaseResponse {
    private List<ItemsVO> itemsVO;
    private RestaurantsEntity resEntity;

    public RestaurantsEntity getResEntity() {
        return resEntity;
    }

    public void setResEntity(RestaurantsEntity resEntity) {
        this.resEntity = resEntity;
    }

    public List<ItemsVO> getItemsVO() {
        return itemsVO;
    }

    public void setItemsVO(List<ItemsVO> itemsVO) {
        this.itemsVO = itemsVO;
    }
}
