package com.ecommerce.restaurant.vo;

import java.sql.Date;

public class OrderDetailsVO {
    private Long id;
    private String status;
    private Integer grand_total;
    private Integer ordered_items_count;
    private Date ordered_date;
    private String delivered_by;
    private String delivery_charge;

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

    public Date getOrdered_date() {
        return ordered_date;
    }

    public void setOrdered_date(Date ordered_date) {
        this.ordered_date = ordered_date;
    }

    public String getDelivered_by() {
        return delivered_by;
    }

    public void setDelivered_by(String delivered_by) {
        this.delivered_by = delivered_by;
    }

    public String getDelivery_charge() {
        return delivery_charge;
    }

    public void setDelivery_charge(String delivery_charge) {
        this.delivery_charge = delivery_charge;
    }
}
