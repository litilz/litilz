package com.ecommerce.restaurant.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_ordered_items")
public class OrderedFoodItemsEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FoodOrdersEntity order_id;

    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemsEntity item_id;

    @Column(name = "item_quantity")
    private Integer item_quantity;

    @Column(name = "price")
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FoodOrdersEntity getOrder_id() {
        return order_id;
    }

    public void setOrder_id(FoodOrdersEntity order_id) {
        this.order_id = order_id;
    }

    public ItemsEntity getItem_id() {
        return item_id;
    }

    public void setItem_id(ItemsEntity item_id) {
        this.item_id = item_id;
    }

    public Integer getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(Integer item_quantity) {
        this.item_quantity = item_quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
