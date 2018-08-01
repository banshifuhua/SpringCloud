package com.eamon.eamonhouseconsumer.hystrix;

import com.eamon.eamonhouseconsumer.dto.HouseInfoDto;
import com.eamon.eamonhouseconsumer.feignclient.HouseServerFeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HouseServerFeignClientFallbackFactory implements FallbackFactory<HouseServerFeignClient> {
    @Override
    public HouseServerFeignClient create(Throwable cause) {
        return new HouseServerFeignClient() {
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
                HouseInfoDto houseInfoDto = new HouseInfoDto(1L,"","","no");
                return houseInfoDto;
            }
        };
    }
}
