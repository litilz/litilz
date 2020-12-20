package com.ecommerce.litil.controller;


import com.ecommerce.litil.response.HelpSupportResponse;
import com.ecommerce.litil.service.HelpSupportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelpSupportController {

    private static final Logger logger = LoggerFactory.getLogger(HelpSupportController.class);


    @Autowired
    HelpSupportService helpSupportService;

    @GetMapping(value = "/getHelpSupport")
    public HelpSupportResponse getHelpSupport() {
        return helpSupportService.getHelpSupport();
    }

//    @PostMapping(value = "/addHelpSupport")
//    public HelpSupportResponse addHelpSupport(@RequestBody HelpSupportRequest helpSupportRequest) {
//        return helpSupportService.addHelpSupport(helpSupportRequest);
//    }
}
