package com.ecommerce.litil.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

public class Fast2SmsClient implements SMSClient {

    private static final String URL = "https://www.fast2sms.com/dev/bulk";
    private static final String AUTHORIZATION_KEY = "fSHcnaOJALjWIel65mkpMU01R94EidKNyCrZugYGDTF2V78wbQIztxF781c6AOWS4YZdkiBvEPpbDR5u";
    private static final String SENDER_ID = "FSTSMS";
    private static final String LANGUAGE = "english";
    private static final String ROUTE = "qt";
    private static final Set<Integer> numbers = new HashSet<>();
    private static final String QT_MESSAGE_ID = null;
    private static final String QT_VARIABLES = null;
    private static final String QT_VARIABLE_VALUES = null;
    private static final String FLASH = "0";
    private static final String PIPE = "|";
    private static final String EQUALS = "=";
    private static final String AND = "&";
    private static Logger logger = LoggerFactory.getLogger(Fast2SmsClient.class);
    private RestTemplate template = new RestTemplate();

    @Override
    public MessageResponse send(SMSRequest request) {

        return prepareQtSms(request);

    }

    private MessageResponse prepareQtSms(SMSRequest request) {

        HttpHeaders headers = createHeaders();
        StringBuilder body = createBody(request);
        HttpEntity<String> httpEntity = new HttpEntity(new String(body), headers);
        ResponseEntity<String> response = template.exchange(URL, HttpMethod.POST, httpEntity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            InMemoryUserOtp.getInstance().put(request.getPhoneNumber(), request.getOtp());
        }
        MessageResponse response2 = new MessageResponse();
        response2.setResponseEntity(response);
        return response2;

    }

    private MessageResponse prepareNonQtSms(SMSRequest request) {

        HttpHeaders headers = createHeaders();

        StringBuilder body = createBody(request);

        HttpEntity<String> httpEntity = new HttpEntity(new String(body), headers);

        ResponseEntity<String> response = template.exchange(URL, HttpMethod.POST, httpEntity, String.class);
        MessageResponse response2 = new MessageResponse();
        response2.getParams().put("otp", request.getMessage());
        response2.setResponseEntity(response);
        return response2;
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", AUTHORIZATION_KEY);
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        return headers;
    }


    private StringBuilder createBody(SMSRequest request) {
        StringBuilder body = new StringBuilder()
                .append(MessageConstants.SENDER_ID).append(EQUALS).append(SENDER_ID).append(AND)
                .append(MessageConstants.MESSAGE).append(EQUALS).append(request.getMessage()).append(AND)
                .append(MessageConstants.LANGUAGE).append(EQUALS).append(LANGUAGE).append(AND)
                .append(MessageConstants.ROUTE).append(EQUALS).append(ROUTE).append(AND)
                .append(MessageConstants.NUMBERS).append(EQUALS).append(request.getPhoneNumber()).append(AND)
                .append(MessageConstants.QT_VARIABLES).append(EQUALS).append("{#AA#}").append(AND)
                .append(MessageConstants.QT_VARIABLE_VALUES).append(EQUALS).append(request.getOtp());

        return body;
    }

}
