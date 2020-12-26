package com.ecommerce.repos.twilio;


import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    @Autowired
    TwilioConfiguration twilioConfiguration;

    @Override
    public void sendSms(TwilioSmsRequest smsRequest) {
        if (smsRequest != null) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhone_no());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrial_number());
            MessageCreator creator = Message.creator(to, from, smsRequest.getMessage());
            creator.create();
            LOGGER.info("Sent message successfully");
        } else {
            throw new NullPointerException("phone no cannot be null");
        }

    }
}
