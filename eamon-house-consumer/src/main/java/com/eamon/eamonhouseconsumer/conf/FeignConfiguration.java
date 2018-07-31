package com.eamon.eamonhouseconsumer.conf;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    Logger.Level logger() {
        return Logger.Level.FULL;
    }
}
