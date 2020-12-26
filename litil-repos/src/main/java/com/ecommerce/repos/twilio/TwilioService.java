package com.ecommerce.repos.twilio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    @Autowired
    TwilioSmsSender twilioSmsSender;

    public String sendDetails(String user_id, Long order_id) {
        TwilioSmsRequest twilioSmsRequest = new TwilioSmsRequest();
        twilioSmsRequest.setPhone_no("+918328678447");
        String msg = "new order received with order_id:" + order_id + ", ordered by " + user_id + ".";
        twilioSmsRequest.setMessage(msg);
        twilioSmsSender.sendSms(twilioSmsRequest);
        return "Message has been sent successfully";

    }
}
