//package com.ecommerce.restaurant.controller;
//
//import com.ecommerce.repos.twilio.TwilioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class FoodTwilioController {
//
//    @Autowired
//    TwilioService twilioService;
//
//
//    @PostMapping
//    public String sendDetails(@RequestParam("user_id") String user_id, @RequestParam("order_id") Long order_id) {
//        return twilioService.sendDetails(user_id, order_id);
//    }
//}
