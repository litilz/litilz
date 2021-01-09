package com.ecommerce.restaurant.entity;

import com.ecommerce.repos.entity.AddressEntity;
import com.ecommerce.repos.entity.UserEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "food_order")
public class FoodOrdersEntity {


    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserEntity user_id;

    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RestaurantsEntity restaurant_id;

    @Column(name = "grand_total")
    private Integer grand_total;

    @Column(name = "ordered_items_count")
    private Integer ordered_items_count;

    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AddressEntity address_id;

    @Column(name = "ordered_date")
    private Date ordered_date;

    @Column(name = "status")
    private String status;

    @Column(name = "delivered_by")
    private String delivered_by;

    @Column(name = "delivery_charge")
    private Integer delivery_charge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser_id() {
        return user_id;
    }

    public void setUser_id(UserEntity user_id) {
        this.user_id = user_id;
    }

    public RestaurantsEntity getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(RestaurantsEntity restaurant_id) {
        this.restaurant_id = restaurant_id;
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

    public AddressEntity getAddress_id() {
        return address_id;
    }

    public void setAddress_id(AddressEntity address_id) {
        this.address_id = address_id;
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
