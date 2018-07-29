package com.eamon.eamonhouseconsumer.controller;

import com.eamon.eamonhouseservice.po.HouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class SubtitutionController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/callHello")
    public String callHello() {
        String result = restTemplate.getForObject("http://house-service/house/hello", String.class);
        System.out.println("调用结果：" + result);
        return result;
    }

    @GetMapping("/data")
    public HouseInfo getData(@RequestParam("name") String name) {
        return restTemplate.getForObject("http://house-service/house/data?name=" + name, HouseInfo.class);
    }

    @GetMapping("/data/{name}")
    public String getData2(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://house-service/house/data/{name}", String.class, name);
    }

}
