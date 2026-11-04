package com.saurabh.playground.sec08.consumer;

import com.saurabh.playground.sec08.dto.PhysicalDelivery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class PhysicalDeliveryConsumerConfig {
    Logger log = LoggerFactory.getLogger(PhysicalDeliveryConsumerConfig.class);

    @Bean
    public Consumer<PhysicalDelivery> physicalDeliveryConsumer() {
        return msg -> log.info("Physical delivery msg received: {}", msg);
    }
}
