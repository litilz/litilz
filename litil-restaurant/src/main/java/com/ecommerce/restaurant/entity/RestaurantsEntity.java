package com.ecommerce.restaurant.entity;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "restaurants")
public class RestaurantsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Basic(optional = false)
    private int id;

    @Basic
    @Column(name = "image")
    private String image;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "type")
    private String type;

    @Basic
    @Column(name = "categories")
    private String categories;

    @Basic
    @Column(name = "rating")
    private double rating;

    @Basic
    @Column(name = "min_order")
    private int min_order;

    @Basic
    @Column(name = "estimated_delivery")
    private Date estimated_delivery;

    @Basic
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "restaurant_loc")
    private String restaurant_loc;

    @Basic
    @Column(name = "active")
    private Boolean active;

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
