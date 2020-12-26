package com.ecommerce.repos.twilio;

public interface SmsSender {

    void sendSms(TwilioSmsRequest smsRequest);

    // or maybe void sendSms(String phoneNumber, String message);
}
