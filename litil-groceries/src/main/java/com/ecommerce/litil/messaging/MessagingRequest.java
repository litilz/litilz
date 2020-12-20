package com.ecommerce.litil.messaging;

public class MessagingRequest {

    private Builder builder;

    public MessagingRequest(Builder builder) {
        this.builder = builder;

    }

    public MessageResponse execute() {
        SMSClient client = this.getSender().getClient();
        String templateId = this.getTemplate().getTemplateId();
        String variables = this.getTemplate().getVariables();
        return client.send(new SMSRequest()
                .setMessage(templateId)
                .setPhoneNumber(this.getphoneNumber())
                .setVariables(variables)
                .setOtp(MessagingService.generateOTP()));
    }

    public Sender getSender() {
        return this.builder.sender;
    }

    public MessageType getMessageType() {
        return this.builder.messageType;
    }

    public String getphoneNumber() {
        return this.builder.phoneNumber;
    }


    public MessagingTemplates getTemplate() {
        return this.builder.template;
    }


    static class Builder {
        private Sender sender;
        private MessageType messageType;
        private String phoneNumber;
        private MessagingTemplates template;


        public Builder messageType(MessageType messageType) {
            this.messageType = messageType;
            return this;
        }

        public Builder withSender(Sender sender) {
            this.sender = sender;
            return this;
        }


        public Builder template(MessagingTemplates template) {
            this.template = template;
            return this;
        }

        public Builder to(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }


        public MessagingRequest build() {


            return new MessagingRequest(this);
        }


    }

}
