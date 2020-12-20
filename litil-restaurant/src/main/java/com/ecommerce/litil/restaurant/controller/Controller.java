package com.ecommerce.litil.restaurant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/res")
public class Controller {

    @GetMapping("/health")
    public String health(){
        return "working";
    }
}
