package com.eamon.eamonfshapi.conf;

import com.eamon.eamonfshapi.filter.ErrorFilter;
import com.eamon.eamonfshapi.filter.IpFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public IpFilter ipFilter() {
        return new IpFilter();
    }

    @Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }
}
