package com.eamon.eamonhouseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EamonHouseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EamonHouseServiceApplication.class, args);
    }
}
