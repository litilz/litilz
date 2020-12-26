package com.ecommerce.repos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "media_order")
public class MediaOrderEntity implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserEntity user_id;

    @Basic
    @Column(name = "category", nullable = false, length = 255)
    private String category;
    @Basic
    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Basic
    @Column(name = "phone", nullable = false, length = 255)
    private String phone;

    @Basic
    @Column(name = "amount", nullable = false, length = 255)
    private String amount;

    @Basic
    @Column(name = "status", nullable = false, length = 255)
    private String status;

    @Basic
    @Column(name = "deliveryby", length = 255)
    private String deliveryby;

    @Basic
    @Column(name = "ordered", nullable = false, length = 255)
    private Date ordered;

    @Basic
    @Column(name = "image", nullable = false, length = 255)
    private String image;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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

    public Date getOrdered() {
        return ordered;
    }

    public void setOrdered(Date ordered) {
        this.ordered = ordered;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "MediaOrderEntity{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", phone='" + phone + '\'' +
                ", amount='" + amount + '\'' +
                ", status='" + status + '\'' +
                ", image='" + image + '\'' +
                ", deliveryby='" + deliveryby + '\'' +
                ", ordered=" + ordered +
                '}';
    }
}
