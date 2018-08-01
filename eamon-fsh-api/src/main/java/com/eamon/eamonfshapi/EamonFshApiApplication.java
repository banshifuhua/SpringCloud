package com.eamon.eamonfshapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//开启路由代理功能
@EnableZuulProxy
public class EamonFshApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EamonFshApiApplication.class, args);
    }
}
