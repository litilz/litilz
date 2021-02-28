package com.ecommerce.litil.vo;

import java.util.List;

public class OrdersListVO {
    private Integer orderId;
    private String user_id;
    private AddressVO address;
    private String total;
    private String status;
    private String deliveryby;
    private List<ProductVO> productIdsList;

    public Integer getOrderId() {
        return orderId;
    }

    public String getUserid() {
        return user_id;
    }

    public AddressVO getAddress() {
        return address;
    }

    public void setAddress(AddressVO address) {
        this.address = address;
    }

    public String getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public String getDeliveryby() {
        return deliveryby;
    }

    public List<ProductVO> getProductIdsList() {
        return productIdsList;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setUserid(String userid) {
        this.user_id = user_id;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDeliveryby(String deliveryby) {
        this.deliveryby = deliveryby;
    }

    public void setProductIdsList(List<ProductVO> productIdsList) {
        this.productIdsList = productIdsList;
    }


}
