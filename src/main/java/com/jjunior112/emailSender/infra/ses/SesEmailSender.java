package com.jjunior112.emailSender.infra.ses;

import com.jjunior112.emailSender.adapters.EmailSenderGateway;
import com.jjunior112.emailSender.core.Exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

import java.util.Collections;

@Service
public class SesEmailSender implements EmailSenderGateway {

    private final SesClient sesClient;
    @Value("${application.email.source}")
    private String emailSource;

    @Autowired
    public SesEmailSender( SesClient sesClient)
    {
        this.sesClient = sesClient;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = SendEmailRequest.builder()
                .destination(Destination.builder()
                        .toAddresses(Collections.singletonList(to))
                        .build())
                .message(Message.builder()
                        .subject(Content.builder()
                                .data(subject)
                                .charset("UTF-8")
                                .build())
                        .body(Body.builder()
                                .text(Content.builder()
                                        .data(body)
                                        .charset("UTF-8")
                                        .build())
                                .build())
                        .build())
                .source(emailSource)
                .build();

        try{
            sesClient.sendEmail(request);
        }
        catch (SesException exception)
        {
            throw new EmailServiceException("Failure while sending email",exception);
        }

    }
}
