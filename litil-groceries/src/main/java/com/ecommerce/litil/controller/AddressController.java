package com.ecommerce.litil.controller;

import com.ecommerce.litil.request.AddressRequest;
import com.ecommerce.litil.response.AddressResponse;
import com.ecommerce.litil.response.BaseResponse;
import com.ecommerce.litil.response.PincodeResponse;
import com.ecommerce.litil.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/address", produces = "application/json")
public class AddressController {

    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    AddressService addressService;

    @PostMapping(value = "/addAddress")
    public AddressResponse addAddress(@RequestBody AddressRequest addressRequest) {
        return addressService.addAddress(addressRequest);
    }

    @GetMapping(value = "/getAllAddress")
    public AddressResponse getAllAddress(@RequestParam(name = "user_name", required = true) String user_name) {
        return addressService.getAllAddress(user_name);
    }

    @GetMapping(value = "/getPincode")
    public PincodeResponse getPincode() {
        return addressService.getPincode();
    }

    @GetMapping(value = "/deleteAddress")
    public BaseResponse deleteAddress(@RequestParam(name = "id", required = true) Integer id) {
        return addressService.deleteAddress(id);
    }
    
    @PostMapping(value = "/updateAddress")
    public AddressResponse updateAddress(@RequestBody AddressRequest addressRequest) {
        return addressService.updateAddress(addressRequest);
    }

    @GetMapping(value = "/setActive")
    public BaseResponse setActive(@RequestParam(name = "addressId") Integer addressId, @RequestParam(name = "user_name") String user_name) {
        return addressService.setActive(addressId, user_name);
    }


}
