package com.ecommerce.litil.controller;


import com.ecommerce.litil.request.CartRequest;
import com.ecommerce.litil.response.BaseResponse;
import com.ecommerce.litil.response.CartResponse;
import com.ecommerce.litil.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cart")
public class CartController {


    @Autowired
    CartService cartService;

    @PostMapping("/createCart")
    public BaseResponse createCart(@RequestBody CartRequest cartRequest) {
        return cartService.createCart(cartRequest.getCartVO());
    }

    @GetMapping("/getCart")
    public CartResponse getCart(@RequestParam(name = "user_name", required = true) String user_name) {
        return cartService.getCart(user_name);
    }

    @GetMapping("/clearCart")
    public void clearCart(@RequestParam(name = "user_name", required = true) String user_name) {
        cartService.clearCart(user_name);
    }


}
