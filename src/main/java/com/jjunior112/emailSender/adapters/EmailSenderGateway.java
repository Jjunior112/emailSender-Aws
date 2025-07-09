package com.jjunior112.emailSender.adapters;

public interface EmailSenderGateway {
    void sendEmail(String to,String subject,String body);
}
