package com.ecommerce.litil.response;

import com.ecommerce.litil.vo.ProductVO;

import java.util.List;

public class OrdersListResponse extends BaseResponse {

    private List<ProductVO> ordersList;

    public List<ProductVO> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<ProductVO> ordersList) {
        this.ordersList = ordersList;
    }
}
