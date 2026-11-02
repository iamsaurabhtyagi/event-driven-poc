package com.saurabh.playground.sec06.consumer;

import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MessageCounter {
    private static final Logger log = LoggerFactory.getLogger(MessageCounter.class);
    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    @PreDestroy
    public void onShutDown() {
        log.info("Total message consumed: {}", counter.get());
    }

}
