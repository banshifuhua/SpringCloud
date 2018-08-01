package com.eamon.eamonhouseconsumer.hystrix;

import com.eamon.eamonhouseconsumer.dto.HouseInfoDto;
import com.eamon.eamonhouseconsumer.feignclient.HouseServerFeignClient;
import org.springframework.stereotype.Component;

@Component
public class HouseServerFeignClientHystrix implements HouseServerFeignClient {
    @Override
    public String hello() {
        return null;
    }

    @Override
    public Object getData(String name) {
        return null;
    }

    @Override
    public HouseInfoDto houseInfo(Long houseId) {
        return new HouseInfoDto();
    }
}
