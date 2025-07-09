package com.jjunior112.emailSender.application;

import com.jjunior112.emailSender.adapters.EmailSenderGateway;
import com.jjunior112.emailSender.core.EmailSenderUseCase;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService  implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    public EmailSenderService(EmailSenderGateway emailSenderGateway)
    {
        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to,subject,body);

    }
}
