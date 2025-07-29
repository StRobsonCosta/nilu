package com.kavex.nilu.infra.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.sns.SnsClient;

@Configuration
public class SNSClientConfig {

    @Bean
    public SnsClient snsClient() {
        return SnsClient.create(); // usa credenciais da role IAM ou perfil local
    }
}
