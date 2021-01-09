package com.ecommerce.restaurant.vo;

public class OrderRequestVO {
    private String userName;
    private String restaurantName;
    private Integer grand_total;
    private Integer ordered_items_count;
    private Integer address_id;

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

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }
}
