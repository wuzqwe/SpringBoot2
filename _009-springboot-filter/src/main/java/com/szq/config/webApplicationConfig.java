package com.szq.config;

import com.szq.web.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class webApplicationConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new MyFilter());
        bean.addUrlPatterns("/user/*");

        return bean;
    }
}
