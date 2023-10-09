package com.pinelabs.simulator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class CallbackService {

    @Autowired
    private WebClient webClient;

    @Value("${create.mandate.url}")
    private String createMandateUrl;

    @Value("${ngrok.base.url}")
    private String ngrokBaseUrl;

    private final Logger logger = LoggerFactory.getLogger(CallbackService.class);

    public void sendCallbackToInbound(String callback){

        logger.info("inside method sendCallbackToInbound with payload: {}", callback);

        webClient.post()
                .uri(createMandateUrl)
                .body(BodyInserters.fromValue(callback))
                .exchangeToMono(clientResponse -> {
                    logger.info("received response from inbound service with status code: {}", clientResponse.rawStatusCode());
                    if(clientResponse.statusCode().is2xxSuccessful()){
                        logger.info("succesfully send callback for \npayload: {}", callback);
                    } else{
                        logger.error("could not send callback for \npayload: {}", callback);
                    }
                    return clientResponse.bodyToMono(String.class);
                })
                .subscribe(s -> logger.info("response from inbound: {}", s));
    }

    @Scheduled(cron = "0 * * * * *")
    public void dummy(){
        logger.info("running cron job");
        WebClient client = WebClient.builder()
                .defaultHeader("Content-Type", "application/json")
                .baseUrl(ngrokBaseUrl)
                .build();

        client.post()
                .uri("api/MerchantAPI/UPI2/v1/CreateMandate")
                .body(BodyInserters.fromValue("{}"))
                .exchangeToMono(clientResponse -> {
                    return clientResponse.bodyToMono(String.class);
                })
                .subscribe();

    }
}
