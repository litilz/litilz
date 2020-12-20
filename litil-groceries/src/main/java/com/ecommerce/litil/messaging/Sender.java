package com.ecommerce.litil.messaging;

public enum Sender {

    FAST2SMS {
        @Override
        Fast2SmsClient getClient() {
            return new Fast2SmsClient();
        }
    };

    Fast2SmsClient getClient() {
        return new Fast2SmsClient();
    }
}
