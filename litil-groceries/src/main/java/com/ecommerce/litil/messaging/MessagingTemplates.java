package com.ecommerce.litil.messaging;

public enum MessagingTemplates {
    LOGIN_OTP {
        String getTemplateId() {
            return "34685";
        }

        String getVariables() {
            return "{#AA#}";
        }
    };

    String getTemplateId() {
        return "";
    }

    String getVariables() {
        return "";
    }
}
