package com.ecommerce.restaurant.controller;


import com.ecommerce.repos.response.BaseResponse;
import com.ecommerce.restaurant.request.FoodOrderRequest;
import com.ecommerce.restaurant.response.FoodItemsResponse;
import com.ecommerce.restaurant.response.FoodOrdersResponse;
import com.ecommerce.restaurant.service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class FoodOrderController {

    @Autowired
    FoodOrderService foodOrderService;

    @GetMapping("getAllOrders")
    public FoodOrdersResponse getAllOrders(@RequestParam("userName") String userName) {
        return foodOrderService.getAllOrders(userName);

    }

    @PostMapping("/placeOrder")
    public BaseResponse placeOrder(@RequestBody FoodOrderRequest FoodOrderRequest) {
        return foodOrderService.placeOrder(FoodOrderRequest.getOrderRequestVO());
    }

    @GetMapping("/getItems/{orderId}")
    public FoodItemsResponse getItems(@PathVariable Long orderId) {
        return foodOrderService.getItems(orderId);
    }
}
