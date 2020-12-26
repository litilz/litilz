package com.ecommerce.restaurant.vo;


import java.sql.Date;

public class RestaurantsVO {
    private int id;
    private String image;
    private String name;
    private String type;
    private String categories;
    private double rating;
    private int min_order;
    private Date estimated_delivery;
    private String phone;
    private String restaurant_loc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getMin_order() {
        return min_order;
    }

    public void setMin_order(int min_order) {
        this.min_order = min_order;
    }

    public Date getEstimated_delivery() {
        return estimated_delivery;
    }

    public void setEstimated_delivery(Date estimated_delivery) {
        this.estimated_delivery = estimated_delivery;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRestaurant_loc() {
        return restaurant_loc;
    }

    public void setRestaurant_loc(String restaurant_loc) {
        this.restaurant_loc = restaurant_loc;
    }
}
