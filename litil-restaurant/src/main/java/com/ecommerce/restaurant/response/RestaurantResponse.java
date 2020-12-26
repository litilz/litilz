package com.ecommerce.restaurant.response;

import com.ecommerce.restaurant.vo.ItemsVO;

import java.util.List;

public class RestaurantResponse {

    private String name;
    private String location;
    private List<ItemsVO> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<ItemsVO> getItems() {
        return items;
    }

    public void setItems(List<ItemsVO> items) {
        this.items = items;
    }
}
