package com.ecommerce.litil.messaging;

import com.ecommerce.litil.request.LoginRequest;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MessagingService {


    public static String generateOTP() {
        Random random = new Random();
        int otp = ThreadLocalRandom.current().nextInt(1000, 9999);
        return String.valueOf(otp);
    }

    public MessageResponse sendSMS(LoginRequest request) {
        MessagingRequest.Builder mrb = new MessagingRequest.Builder();
        return mrb.messageType(MessageType.SMS)
                .withSender(Sender.FAST2SMS)
                .to(request.getPhoneNumber())
                .template(MessagingTemplates.LOGIN_OTP)
                .build().execute();

    }

}



