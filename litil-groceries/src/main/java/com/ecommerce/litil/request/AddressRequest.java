package com.ecommerce.litil.request;

import com.ecommerce.litil.vo.AddressVO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressRequest {

    @JsonProperty("data")
    private AddressVO addressVO;

    public AddressVO getAddressVO() {
        return addressVO;
    }

    public void setAddressVO(AddressVO addressVO) {
        this.addressVO = addressVO;
    }
}