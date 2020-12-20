package com.ecommerce.litil.request;

import com.ecommerce.litil.vo.UserVO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {

    @JsonProperty("data")
    private UserVO user;

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

}
