package com.ecommerce.litil.messaging;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserOtp {

    private static Map<String, String> map = null;

    private InMemoryUserOtp() {
    }

    public static Map<String, String> getInstance() {
        if (map == null) {
            synchronized (InMemoryUserOtp.class) {
                return map = new HashMap<>();
            }
        }
        return map;
    }
}
