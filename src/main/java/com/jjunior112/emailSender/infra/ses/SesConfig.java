package com.jjunior112.emailSender.infra.ses;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;

@Configuration
public class SesConfig {

    @Value("${region}")
    private String region;

    @Value("${accessKeyId}")
    private String accessKeyId;

    @Value("${secretKey}")
    private String secretKey;

    @Bean
    public SesClient sesClient() {
        AwsBasicCredentials credentials = AwsBasicCredentials.create(
                accessKeyId,
                secretKey
        );

        return SesClient.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }
}
