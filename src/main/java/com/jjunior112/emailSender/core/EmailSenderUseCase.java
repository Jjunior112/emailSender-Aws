package com.jjunior112.emailSender.core;

public interface EmailSenderUseCase {
    void sendEmail(String to, String subject,String body);
}
