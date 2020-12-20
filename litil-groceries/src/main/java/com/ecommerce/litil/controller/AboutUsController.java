package com.ecommerce.litil.controller;


import com.ecommerce.litil.response.AboutUsResponse;
import com.ecommerce.litil.service.AboutUsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutUsController {


    private static final Logger logger = LoggerFactory.getLogger(AboutUsController.class);
    @Autowired
    AboutUsService aboutUsService;

    @GetMapping(value = "/getAboutUs")
    public AboutUsResponse getaboutUs() {
        return aboutUsService.getaboutUs();
    }


//    @PostMapping(value = "/addAboutUs")
//    public AboutUsResponse addAboutUs(@RequestBody AboutUSRequest aboutUSRequest) {
//        return aboutUsService.addAboutUS(aboutUSRequest);
//    }
}
