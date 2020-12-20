package com.ecommerce.litil.messaging;

public class TemplateDataCombiner<String, T> {

    protected String message;
    protected T data;

    String combine(String message, T data) {

        return message;
    }

}
