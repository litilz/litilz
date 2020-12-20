package com.ecommerce.litil.request;

import com.ecommerce.litil.vo.WishVO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WishRequest {

    @JsonProperty("data")
    private WishVO wishVo;

    public WishVO getWishVo() {
        return wishVo;
    }

    public void setWishVo(WishVO wishVo) {
        this.wishVo = wishVo;
    }


}
