package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EngClientApp {

    public static void main(String[] args) {
        SpringApplication.run(EngClientApp.class, args);
    }
}
