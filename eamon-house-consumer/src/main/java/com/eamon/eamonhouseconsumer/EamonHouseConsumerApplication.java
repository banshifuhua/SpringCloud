package com.eamon.eamonhouseconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EamonHouseConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EamonHouseConsumerApplication.class, args);
    }

}
