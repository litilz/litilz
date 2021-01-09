package com.ecommerce.restaurant.response;

import com.ecommerce.repos.response.BaseResponse;
import com.ecommerce.restaurant.vo.OrderResponseVO;

import java.util.List;

public class FoodOrdersResponse extends BaseResponse {

    private List<OrderResponseVO> orderResponseVOList;


    public List<OrderResponseVO> getOrderResponseVOList() {
        return orderResponseVOList;
    }

    public void setOrderResponseVOList(List<OrderResponseVO> orderResponseVOList) {
        this.orderResponseVOList = orderResponseVOList;
    }


}
