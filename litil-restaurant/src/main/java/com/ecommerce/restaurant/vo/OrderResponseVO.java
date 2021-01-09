package com.ecommerce.restaurant.vo;

import com.ecommerce.repos.entity.AddressEntity;

import java.util.Date;

public class OrderResponseVO {
    private Long id;
    private String userName;
    private String restaurantName;
    private Integer grand_total;
    private Integer ordered_items_count;
    private AddressEntity addressEntity;
    private Date ordered_date;
    private String status;
    private String delivered_by;
    private Integer delivery_charge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Integer getGrand_total() {
        return grand_total;
    }

    public void setGrand_total(Integer grand_total) {
        this.grand_total = grand_total;
    }

    public Integer getOrdered_items_count() {
        return ordered_items_count;
    }

    public void setOrdered_items_count(Integer ordered_items_count) {
        this.ordered_items_count = ordered_items_count;
    }


    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public Date getOrdered_date() {
        return ordered_date;
    }

    public void setOrdered_date(Date ordered_date) {
        this.ordered_date = ordered_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelivered_by() {
        return delivered_by;
    }

    public void setDelivered_by(String delivered_by) {
        this.delivered_by = delivered_by;
    }

    public Integer getDelivery_charge() {
        return delivery_charge;
    }

    public void setDelivery_charge(Integer delivery_charge) {
        this.delivery_charge = delivery_charge;
    }


}
