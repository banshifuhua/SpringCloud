package com.eamon.eamonhouseconsumer.feignclient;

import com.eamon.eamonhouseconsumer.conf.FeignConfiguration;
import com.eamon.eamonhouseconsumer.dto.HouseInfoDto;
import com.eamon.eamonhouseconsumer.hystrix.HouseServerFeignClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "house-service", path = "/house", configuration = FeignConfiguration.class
        , fallback = HouseServerFeignClientHystrix.class)
public interface HouseServerFeignClient {
    @GetMapping("/hello")
    String hello();

    @GetMapping("/data")
    Object getData(@RequestParam("name") String name);

    @GetMapping("/{houseId}")
    HouseInfoDto houseInfo(@PathVariable("houseid") Long houseId);

}
