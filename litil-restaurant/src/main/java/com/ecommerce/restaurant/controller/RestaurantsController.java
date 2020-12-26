package com.ecommerce.restaurant.controller;


import com.ecommerce.restaurant.response.RestaurantResponse;
import com.ecommerce.restaurant.response.RestaurantsResponse;
import com.ecommerce.restaurant.service.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantsController {

    @Autowired
    RestaurantsService restaurantsService;

    @GetMapping
    public RestaurantsResponse getAll() {
        return restaurantsService.getAll();
    }

    @GetMapping("/{restaurantName}")
    public RestaurantResponse displayMenu(@PathVariable("restaurantName") String restaurantName) {
        return restaurantsService.displayMenu(restaurantName);
    }


}
