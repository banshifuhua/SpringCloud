package com.eamon.eamonhystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class EamonHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(EamonHystrixDashboardApplication.class, args);
    }
}
