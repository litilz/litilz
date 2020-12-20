package com.ecommerce.litil.twilio;


import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitializer {

    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);

    @Autowired
    TwilioConfiguration twilioConfiguration;

    @Autowired
    public void init() {
        Twilio.init(
                twilioConfiguration.getAccount_sid(),
                twilioConfiguration.getAuth_token()
        );
        LOGGER.info("Twilio initialized ... with account sid {} ", twilioConfiguration.getAccount_sid());
    }

}
