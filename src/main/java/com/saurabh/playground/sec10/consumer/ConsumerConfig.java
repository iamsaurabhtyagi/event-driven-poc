package com.saurabh.playground.sec10.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

@Configuration
public class ConsumerConfig {
    Logger log = LoggerFactory.getLogger(ConsumerConfig.class);

    @Bean
    public Consumer<List<String>> messageConsumer() {
        var counter = new AtomicInteger(0);
        return msg -> {
            log.info("Received messages: {}, Total Processed:{}", msg.size(), counter.addAndGet(msg.size()));
        };
    }
}
