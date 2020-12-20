package com.ecommerce.litil.twilio;


public class TwilioSmsRequest {
    private String phone_no;
    private String message;

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TwilioSmsRequest{" +
                "phone_no='" + phone_no + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
