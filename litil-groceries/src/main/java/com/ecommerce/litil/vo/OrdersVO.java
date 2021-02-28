package com.ecommerce.litil.vo;

public class OrdersVO {

    private Long id;
    private String user_id;
    private Integer address_id;
    private String phone;
    private String status;
    private String deliveryby;
    private String discount;
    private String selling;
    private String original;
    private String image_url;
    private String date_ordered;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate_ordered() {
        return date_ordered;
    }

    public void setDate_ordered(String date_ordered) {
        this.date_ordered = date_ordered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_name) {
        this.user_id = user_name;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryby() {
        return deliveryby;
    }

    public void setDeliveryby(String deliveryby) {
        this.deliveryby = deliveryby;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getSelling() {
        return selling;
    }

    public void setSelling(String selling) {
        this.selling = selling;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }
}
