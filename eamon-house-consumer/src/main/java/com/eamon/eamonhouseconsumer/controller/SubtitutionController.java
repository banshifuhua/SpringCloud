package com.eamon.eamonhouseconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class SubtitutionController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/callHello")
    public String callHello(){
        return restTemplate.getForObject("http://house-service/house/hello", String.class);
    }

}
