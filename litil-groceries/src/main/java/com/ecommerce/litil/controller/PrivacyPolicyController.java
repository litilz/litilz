package com.ecommerce.litil.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrivacyPolicyController {
    @RequestMapping(value = "/PrivacyPolicy")
    public String PrivacyPolicy() {
        return "privacyPolicy";
    }
}
