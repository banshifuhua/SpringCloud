package com.eamon.eamonhystrixdashboart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class EamonHystrixDashboartApplication {

    public static void main(String[] args) {
        SpringApplication.run(EamonHystrixDashboartApplication.class, args);
    }
}
