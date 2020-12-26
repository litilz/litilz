package com.ecommerce.litil.controller;

import com.ecommerce.repos.repository.OrdersRepository;
import com.ecommerce.litil.request.OrderRequest;
import com.ecommerce.litil.response.OrdersListResponse;
import com.ecommerce.litil.response.OrdersResponse;
import com.ecommerce.litil.service.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Orders")
public class OrdersController {

    private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);


    @Autowired
    private OrdersService ordersService;


    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping("/getAllUserOrders")
    public OrdersResponse getAllUserOrders(@RequestParam("user_name") String user_name) {
        return ordersService.getAllUserOrders(user_name);
    }

    @PostMapping("/createOrder")
    public OrdersResponse createOrder(@RequestBody OrderRequest orderRequest) {
        return ordersService.createOrder(orderRequest);
    }

    @GetMapping("/getOrderedProducts")
    public OrdersListResponse getOrderedProducts(@RequestParam Long orderId) {
        return ordersService.getOrderedProducts(orderId);
    }


}
