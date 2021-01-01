package com.ecommerce.restaurant.controller;


import com.ecommerce.restaurant.service.FoodOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "orders")
public class FoodOrdersController {

    @Autowired
    FoodOrdersService foodOrdersService;

//    @GetMapping("/")
//    public void getAllOrders(@RequestParam("user_id") String user_id) {
//        foodOrdersService.findAllUserOrders(user_id);
//
//    }
}
