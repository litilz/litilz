package com.ecommerce.restaurant.entity;

import com.ecommerce.repos.entity.UserEntity;

import javax.persistence.*;


@Entity
@Table(name = "food_cart")
public class FoodCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;


    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserEntity user_id;

    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private  ItemsEntity item_id;


    @Column(name = "quantity")
    private  int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUser_id() {
        return user_id;
    }

    public void setUser_id(UserEntity user_id) {
        this.user_id = user_id;
    }

    public ItemsEntity getItem_id() {
        return item_id;
    }

    public void setItem_id(ItemsEntity item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
