package com.ecommerce.litil.messaging;

public class SMSRequest {

    private String message;
    private String phoneNumber;
    private String otp;
    private String variables;
    private String variableValues;

    public SMSRequest() {

    }

    public SMSRequest(String message, String phoneNumber) {
        this.message = message;
        this.phoneNumber = phoneNumber;
    }

    public SMSRequest(String message, String phoneNumber, String otp) {
        this.message = message;
        this.phoneNumber = phoneNumber;
        this.otp = otp;
    }

    public String getMessage() {
        return message;
    }

    public SMSRequest setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public SMSRequest setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getOtp() {
        return otp;
    }

    public SMSRequest setOtp(String otp) {
        this.otp = otp;
        return this;
    }

    public String getVariables() {
        return variables;
    }

    public SMSRequest setVariables(String variables) {
        this.variables = variables;
        return this;
    }

    public String getVariableValues() {
        return variableValues;
    }

    public SMSRequest setVariableValues(String variableValues) {
        this.variableValues = variableValues;
        return this;
    }
}
