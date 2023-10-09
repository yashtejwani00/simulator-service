package com.pinelabs.simulator.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;




@Configuration
public class Config {

    @Value("${qa.base.url}")
    private String qaBaseUrl;

    @Bean
    public WebClient getWebClient(){
        return WebClient.builder()
                .defaultHeader("Content-Type", "application/json")
                .baseUrl(qaBaseUrl)
                .build();
    }
}
