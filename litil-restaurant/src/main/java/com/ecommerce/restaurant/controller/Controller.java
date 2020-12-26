package com.ecommerce.restaurant.controller;

import com.ecommerce.repos.entity.UserEntity;
import com.ecommerce.repos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/res")
public class Controller {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/health")
    public String health(){
        return "working";
    }



    @GetMapping("findOne")
    public UserEntity get(){
        UserEntity u = userRepository.findByUserId("9951161771");
        return u;
    }
}
