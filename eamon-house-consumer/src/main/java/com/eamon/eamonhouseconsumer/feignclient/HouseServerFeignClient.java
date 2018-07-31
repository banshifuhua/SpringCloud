package com.eamon.eamonhouseconsumer.feignclient;

import com.eamon.eamonhouseconsumer.conf.FeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "house-service", path = "/house", configuration = FeignConfiguration.class)
public interface HouseServerFeignClient {
    @GetMapping("/hello")
    String hello();

    @GetMapping("/data")
    Object getData(@RequestParam("name") String name);

}
