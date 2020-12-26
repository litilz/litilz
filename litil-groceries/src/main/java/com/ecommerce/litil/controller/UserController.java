package com.ecommerce.litil.controller;


import com.ecommerce.repos.repository.UserRepository;
import com.ecommerce.litil.request.UserRequest;
import com.ecommerce.litil.response.UserResponse;
import com.ecommerce.litil.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/saveUser")
    public UserResponse saveUser(@RequestBody UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }

    @GetMapping(value = "/getUser")
    public UserResponse getUser(@RequestParam(name = "user_name", required = true) String user_name) {
        return userService.getUser(user_name);
    }
}
