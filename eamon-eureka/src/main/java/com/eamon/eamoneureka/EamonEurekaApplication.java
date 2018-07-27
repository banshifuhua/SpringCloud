package com.eamon.eamoneureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EamonEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EamonEurekaApplication.class, args);
    }
}
