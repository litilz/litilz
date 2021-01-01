package com.ecommerce.restaurant.controller;


import com.ecommerce.repos.entity.UserEntity;
import com.ecommerce.repos.repository.UserRepository;
import com.ecommerce.repos.response.BaseResponse;
import com.ecommerce.restaurant.request.FoodCartRequest;
import com.ecommerce.restaurant.response.FoodCartResponse;
import com.ecommerce.restaurant.service.FoodCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/food")
public class FoodCartController {

    @Autowired
    FoodCartService foodCartService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/addCart")
    public BaseResponse createCart(@RequestBody FoodCartRequest foodCartRequest) {
        return foodCartService.createCart(foodCartRequest.getFoodCartVO());
    }

    @GetMapping("/getCart")
    public FoodCartResponse getCart(@RequestParam(name = "user_name", required = true) String user_name) {
        return foodCartService.getCart(user_name);
    }

    @DeleteMapping("/deleteCart")
    public void clearCart(@RequestParam(name = "user_name", required = true) String user_name) {
        UserEntity uEntity = userRepository.findByUserId(user_name);
        foodCartService.clearCart(uEntity);
    }
}
