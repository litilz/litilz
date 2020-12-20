package com.ecommerce.litil.controller;

import com.ecommerce.litil.messaging.InMemoryUserOtp;
import com.ecommerce.litil.messaging.MessageResponse;
import com.ecommerce.litil.messaging.MessagingService;
import com.ecommerce.litil.messaging.VerifyRequest;
import com.ecommerce.litil.request.LoginRequest;
import com.ecommerce.litil.response.BaseResponse;
import com.ecommerce.litil.response.LoginResponse;
import com.ecommerce.litil.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    Map<String, String> phoneVsOtp = new HashMap<>();
    @Autowired
    private MessagingService messagingService;
    @Autowired
    private UserService userService;


    @PostMapping("/verify")
    public BaseResponse verifyOtp(@RequestBody VerifyRequest request) {
        BaseResponse baseResponse = new BaseResponse ();
        if (request.getOtp().equals(InMemoryUserOtp.getInstance().get(request.getPhone()))) {
            InMemoryUserOtp.getInstance().remove(request.getPhone());
            return userService.getUserByPhone(request.getPhone());
        }
        baseResponse.setStatusCode ( HttpStatus.BAD_REQUEST.name () );
        baseResponse.setStatusDesc ( "Invalid Otp" );
        return  baseResponse;
    }


    @PostMapping("/login")
    public BaseResponse loginWithPhone(@RequestBody LoginRequest loginRequest) {
        BaseResponse baseResponse = new BaseResponse ();
        if (loginRequest.getPhoneNumber() != null && !loginRequest.getPhoneNumber().isEmpty()) {
            MessageResponse response =  messagingService.sendSMS(loginRequest);
            baseResponse.setStatusCode ( response.getResponseEntity ().getStatusCode ().name () );
            baseResponse.setStatusDesc ( "OTP Sent Successfully" );
        } else {
            baseResponse.setStatusCode (HttpStatus.BAD_REQUEST.name ()  );
            baseResponse.setStatusDesc ( "Please enter a valid phone number" );
        }
        return baseResponse;
    }
}
