package com.ecommerce.litil.request;

public class LoginRequest {

    private String phoneNumber;

    public LoginRequest() {
    }

    public LoginRequest(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
