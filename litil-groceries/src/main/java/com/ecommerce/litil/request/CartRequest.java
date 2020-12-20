package com.ecommerce.litil.request;

import com.ecommerce.litil.vo.CartVO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CartRequest {

    @JsonProperty("data")
    private CartVO cartVO;

    public CartVO getCartVO() {
        return cartVO;
    }

    public void setCartVO(CartVO cartVO) {
        this.cartVO = cartVO;
    }
}
