package com.eamon.eamoneurekaslaveone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EamonEurekaSlaveoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(EamonEurekaSlaveoneApplication.class, args);
    }
}
