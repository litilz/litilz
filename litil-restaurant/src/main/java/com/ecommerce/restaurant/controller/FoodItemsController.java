package com.ecommerce.restaurant.controller;


import com.ecommerce.restaurant.entity.ItemsEntity;
import com.ecommerce.restaurant.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class FoodItemsController {

    @Autowired
    ItemsService itemsService;


    @GetMapping("/items")
    public List<ItemsEntity> getItems() {
        return itemsService.getItems();
    }

}
