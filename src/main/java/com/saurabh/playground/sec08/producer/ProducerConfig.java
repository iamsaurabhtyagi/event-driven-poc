package com.saurabh.playground.sec08.producer;

import com.saurabh.playground.sec07.dto.Order;
import com.saurabh.playground.sec07.dto.ProductType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

@Configuration
public class ProducerConfig {
    Logger log = LoggerFactory.getLogger(com.saurabh.playground.sec07.producer.ProducerConfig.class);

    @Bean
    public Supplier<Order> orderProducer() {
        var counter = new AtomicInteger(0);

        return () -> {
            var id = counter.incrementAndGet();
            var productType = id % 2 == 0 ? ProductType.DIGITAL : ProductType.PHYSICAL;
            var order = new Order(id, id, ThreadLocalRandom.current().nextInt(1, 1000), productType);
            log.info("produced: {}", order);
            return order;
        };
    }
}
