package com.ecommerce.litil.response;

import com.ecommerce.litil.messaging.MessageResponse;
import org.springframework.http.ResponseEntity;

public class LoginResponse extends MessageResponse {


    private Object o;

    public LoginResponse() {
        super();
    }

    public LoginResponse(ResponseEntity responseEntity) {
        super.responseEntity = responseEntity;
    }

    public LoginResponse(ResponseEntity responseEntity, Object o) {
        this.responseEntity = responseEntity;
        this.o = o;
    }
}
