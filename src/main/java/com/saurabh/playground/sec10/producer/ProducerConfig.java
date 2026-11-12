package com.saurabh.playground.sec10.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class ProducerConfig implements CommandLineRunner {
    Logger log = LoggerFactory.getLogger(ProducerConfig.class);
    private static final String DEMO_OUT = "demo-out";
    private final StreamBridge streamBridge;

    public ProducerConfig(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i = 0; i < 1_000_000; i++) {
            streamBridge.send(DEMO_OUT, "msg-"+i);
            if(i % 1000 == 0) {
                log.info("Total message produced: {}", i);
                Thread.sleep(Duration.ofMillis(10));
            }
        }
    }
}
