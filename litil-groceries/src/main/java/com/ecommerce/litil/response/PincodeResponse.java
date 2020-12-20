package com.ecommerce.litil.response;

import com.ecommerce.litil.entity.PincodeEntity;

import java.util.List;

public class PincodeResponse extends BaseResponse {
    List<PincodeEntity> pincode;

    public List<PincodeEntity> getPincode() {
        return pincode;
    }

    public void setPincode(List<PincodeEntity> pincode) {
        this.pincode = pincode;
    }
}
