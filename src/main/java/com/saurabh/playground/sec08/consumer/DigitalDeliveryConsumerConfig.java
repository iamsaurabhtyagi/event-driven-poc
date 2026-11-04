package com.saurabh.playground.sec08.consumer;

import com.saurabh.playground.sec08.dto.DigitalDelivery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class DigitalDeliveryConsumerConfig {
    Logger log = LoggerFactory.getLogger(DigitalDeliveryConsumerConfig.class);

    @Bean
    public Consumer<DigitalDelivery> digitalDeliveryConsumer() {
        return msg -> log.info("received: {}", msg);
    }
}
