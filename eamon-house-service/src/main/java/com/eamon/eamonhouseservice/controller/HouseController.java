package com.eamon.eamonhouseservice.controller;

import com.eamon.eamonhouseservice.po.HouseInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/hello")
    public String hello() {
        return "Hello" + serverPort;
    }

    @GetMapping("/data")
    public HouseInfo getData(@RequestParam("name") String name) {
        HouseInfo houseInfo = new HouseInfo();
        houseInfo.setId(1L);
        houseInfo.setCity("上海");
        houseInfo.setRegion("虹口");
        houseInfo.setName("东体小区");
        return houseInfo;
    }

    @GetMapping("/data/{name}")
    public String getData2(@PathVariable("name") String name) {
        return name;
    }
}
