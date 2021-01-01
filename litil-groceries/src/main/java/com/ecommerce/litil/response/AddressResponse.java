package com.ecommerce.litil.response;

import com.ecommerce.litil.vo.AddressVO;
import com.ecommerce.repos.response.BaseResponse;

import java.util.List;

public class AddressResponse extends BaseResponse {

    private List<AddressVO> addressList;

    public List<AddressVO> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressVO> addressList) {
        this.addressList = addressList;
    }

}