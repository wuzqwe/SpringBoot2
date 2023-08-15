package com.szq.config;

import com.szq.web.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
import javax.servlet.Servlet;

@Configuration
public class WebSystemConfig {

    //注册Servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){

        ServletRegistrationBean<Servlet> bean = new ServletRegistrationBean<>();
        bean.setServlet(new MyServlet());
        bean.addUrlMappings("/myservlet");

        return bean;
    }

}
