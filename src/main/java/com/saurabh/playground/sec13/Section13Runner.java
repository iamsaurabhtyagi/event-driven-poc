package com.saurabh.playground.sec13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Section13Runner {
    public static void main(String[] args) {
        SpringApplication.run(Section13Runner.class,
                "--section=sec13",
                "--config=04-dlq");
    }
}
