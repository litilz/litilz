package com.ecommerce.litil.entity;

import com.ecommerce.repos.entity.AddressEntity;
import com.ecommerce.repos.entity.UserEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "orders")
public class OrdersEntity implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserEntity user_id;

    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AddressEntity address_id;


    @Basic
    @Column(name = "status", nullable = false, length = 255)
    private String status;

    @Basic
    @Column(name = "deliveryby", nullable = false, length = 255)
    private String deliveryby;

    @Basic
    @Column(name = "discount", nullable = false, length = 255)
    private String discount;

    @Basic
    @Column(name = "selling", nullable = false, length = 255)
    private String selling;

    @Basic
    @Column(name = "original", nullable = false, length = 255)
    private String original;

    @Basic
    @Column(name = "date_ordered", nullable = false, length = 255)
    private Date date_ordered;

    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;

    public int getQuantity () {
        return quantity;
    }

    public void setQuantity ( int quantity ) {
        this.quantity = quantity;
    }

    public UserEntity getUser_id() {
        return user_id;
    }

    public void setUser_id(UserEntity user_id) {
        this.user_id = user_id;
    }

    public AddressEntity getAddress_id() {
        return address_id;
    }

    public void setAddress_id(AddressEntity address_id) {
        this.address_id = address_id;
    }

    public Date getDate_ordered() {
        return date_ordered;
    }

    public void setDate_ordered(Date date_ordered) {
        this.date_ordered = date_ordered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
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

    @Override
    public String toString() {
        return "OrdersEntity{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", address_id=" + address_id +
                ", status='" + status + '\'' +
                ", deliveryby='" + deliveryby + '\'' +
                ", discount='" + discount + '\'' +
                ", selling='" + selling + '\'' +
                ", original='" + original + '\'' +
                ", date_ordered=" + date_ordered +
                '}';
    }
}
