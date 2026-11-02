package com.saurabh.playground.sec06.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class ProducerConfig {
    Logger log = LoggerFactory.getLogger(ProducerConfig.class);

    @Bean
    public Supplier<String> producerEvent() {
        var counter = new AtomicInteger(0);
        return () -> {
            var msg = "msg-" + counter.incrementAndGet();
            log.info("Produced Event: {}", msg);
            return msg;
        };

    }
}
