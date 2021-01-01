package com.ecommerce.litil.response;

import com.ecommerce.repos.entity.PincodeEntity;
import com.ecommerce.repos.response.BaseResponse;

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
