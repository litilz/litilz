package com.ecommerce.litil.controller;


import com.ecommerce.litil.request.WishRequest;
import com.ecommerce.litil.response.WishResponse;
import com.ecommerce.litil.service.WishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/wishList")
public class WishController {

    private static final Logger logger = LoggerFactory.getLogger(WishController.class);


    @Autowired
    WishService wishService;

    @PostMapping(value = "/addRemoveItem")
    public WishResponse addRemoveItem(@RequestBody WishRequest wishRequest) {
        return wishService.addRemoveItem(wishRequest);
    }

    @GetMapping(value = "/getUserWishlist")
    public WishResponse getWishListByUserId(@RequestParam(name = "user_name", required = true) String user_name) {
        return wishService.getWishListByUserId(user_name);
    }
}
