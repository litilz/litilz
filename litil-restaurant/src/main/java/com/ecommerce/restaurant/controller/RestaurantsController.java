package com.ecommerce.restaurant.controller;


import com.ecommerce.restaurant.response.RestaurantResponse;
import com.ecommerce.restaurant.response.RestaurantsResponse;
import com.ecommerce.restaurant.service.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public RestaurantResponse displayMenu(@PathVariable("restaurantName") String restaurantName, @RequestParam(name = "user_name", required = true) String user_name) {
        return restaurantsService.displayMenu(restaurantName,user_name);
    }


}
