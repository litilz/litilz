package com.ecommerce.litil.response;

import com.ecommerce.litil.vo.UserVO;
import com.ecommerce.repos.response.BaseResponse;

public class UserResponse extends BaseResponse {

    private UserVO user;

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

}
