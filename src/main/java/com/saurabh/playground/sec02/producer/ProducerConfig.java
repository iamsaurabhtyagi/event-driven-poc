package com.saurabh.playground.sec02.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

@Configuration
public class ProducerConfig {
    Logger log = LoggerFactory.getLogger(ProducerConfig.class);

    @Bean
    public Supplier<String> producerEvent() {
        var counter = new AtomicInteger(0);

        return () -> {
            var msg = "msg-" + counter.incrementAndGet();
            log.info("Event Produced: {}", msg);
            return msg;
        };
    }
}
