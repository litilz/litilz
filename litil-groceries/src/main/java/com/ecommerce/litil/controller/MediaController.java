//package com.ecommerce.litil.controller;
//
//import com.ecommerce.litil.request.MediaOrderRequest;
//import com.ecommerce.litil.response.CategoryResponse;
//import com.ecommerce.litil.response.MediaOrderResponse;
//import com.ecommerce.litil.response.OrdersResponse;
//import com.ecommerce.litil.service.MediaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class MediaController {
//
//    @Autowired
//    MediaService mediaService;
//
//    @GetMapping("getCategories")
//    public CategoryResponse getCategories() {
//        return mediaService.getCategories();
//    }
//
//    @PostMapping("/createMediaOrder")
//    public MediaOrderResponse createMediaOrder(@RequestBody MediaOrderRequest mediaOrderRequest) {
//        return mediaService.createMediaOrder(mediaOrderRequest);
//    }
//
//    @GetMapping("/getAllUserMediaOrders")
//    public MediaOrderResponse getAllUserMediaOrders(@RequestParam("user_name") String user_name) {
//        return mediaService.getAllUserMediaOrders(user_name);
//    }
//
//}
