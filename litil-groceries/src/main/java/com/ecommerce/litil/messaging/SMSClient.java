package com.ecommerce.litil.messaging;

public interface SMSClient {

    MessageResponse send(SMSRequest request);
}
