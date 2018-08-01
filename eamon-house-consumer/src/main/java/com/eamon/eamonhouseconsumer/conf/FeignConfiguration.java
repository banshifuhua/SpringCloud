package com.eamon.eamonhouseconsumer.conf;

import feign.Logger;
import feign.Request;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    Logger.Level logger() {
        return Logger.Level.FULL;
    }

    /**
     * basic认证
     */
//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
//        return new BasicAuthRequestInterceptor("user", "password");
//    }

    /**
     * 超时时间配置
     *  连接超时，读取超时  毫秒
     * @return
     */
    @Bean
    public Request.Options options(){
        return new Request.Options(5000, 10000);
    }

}
