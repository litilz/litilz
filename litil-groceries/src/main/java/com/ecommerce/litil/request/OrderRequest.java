package com.ecommerce.litil.request;

import com.ecommerce.litil.vo.OrdersVO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderRequest {

    @JsonProperty("data")
    private OrdersVO ordersVO;

    public OrdersVO getOrdersVO() {
        return ordersVO;
    }

    public void setOrdersVO(OrdersVO ordersVO) {
        this.ordersVO = ordersVO;
    }
}
