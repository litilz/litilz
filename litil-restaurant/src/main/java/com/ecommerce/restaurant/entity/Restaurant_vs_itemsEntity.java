package com.ecommerce.restaurant.entity;


import javax.persistence.*;

@Entity
@Table(name = "restaurant_vs_items")
public class Restaurant_vs_itemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RestaurantsEntity restaurant_id;

    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemsEntity item_id;

    @Column(name = "price")
    private int price;

    @Column(name = "quantity")
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RestaurantsEntity getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(RestaurantsEntity restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public ItemsEntity getItem_id() {
        return item_id;
    }

    public void setItem_id(ItemsEntity item_id) {
        this.item_id = item_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
