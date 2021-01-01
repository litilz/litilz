package com.ecommerce.restaurant.response;

import com.ecommerce.repos.response.BaseResponse;
import com.ecommerce.restaurant.entity.RestaurantsEntity;
import com.ecommerce.restaurant.vo.ItemsVO;
import com.ecommerce.restaurant.vo.RestaurantsVO;

import java.util.List;

public class RestaurantResponse extends BaseResponse {

    private RestaurantsVO resVO;
    private List<ItemsVO> items;

    public RestaurantsVO getResVO() {
        return resVO;
    }

    public void setResVO(RestaurantsVO resVO) {
        this.resVO = resVO;
    }

    public List<ItemsVO> getItems() {
        return items;
    }

    public void setItems(List<ItemsVO> items) {
        this.items = items;
    }
}
