package com.eamon.eamonhouseconsumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.eamon.eamonhouseconsumer.feignclient.HouseServerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignConsumerController {

    @Autowired
    HouseServerFeignClient houseServerFeignClient;

    @GetMapping("/callHello")
    public String getHelloByFeign() {
        return houseServerFeignClient.hello();
    }

    @GetMapping("/data")
    public Object getData(@RequestParam("name") String name){
        return  houseServerFeignClient.getData(name);
    }
}
