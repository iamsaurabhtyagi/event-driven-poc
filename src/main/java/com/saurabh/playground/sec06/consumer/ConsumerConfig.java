package com.saurabh.playground.sec06.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class ConsumerConfig {
    Logger log = LoggerFactory.getLogger(ConsumerConfig.class);

    @Bean
    public Consumer<String> consumerEvent(MessageCounter counter) {
        return message -> {
            counter.increment();
            log.info("Received: {}", message);
        };
    }
}
