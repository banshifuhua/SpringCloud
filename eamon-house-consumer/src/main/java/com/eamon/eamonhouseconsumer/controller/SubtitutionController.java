package com.eamon.eamonhouseconsumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.eamon.eamonhouseconsumer.common.CallHelloFallback;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class SubtitutionController {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultCallHello")
    @GetMapping("/callHello")
    public String callHello() {
        String result = restTemplate.getForObject("http://house-service/house/hello", String.class);
        System.out.println("调用结果：" + result);
        return result;
    }

    @GetMapping("/data")
    public JSONObject getData(@RequestParam("name") String name) {
        return restTemplate.getForObject("http://house-service/house/data?name=" + name, JSONObject.class);
    }

    @GetMapping("/data/{name}")
    public String getData2(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://house-service/house/data/{name}", String.class, name);
    }


    public String defaultCallHello() {
        return "fail";
    }

}
