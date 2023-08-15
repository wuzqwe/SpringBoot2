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

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();

        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        //指定使用的编码方式
        filter.setEncoding("utf-8");
        //指定request,response都使用encoding的值
        filter.setForceEncoding(true);

        bean.setFilter(filter);
        //指定过滤的url地址
        bean.addUrlPatterns("/*");

        return bean;
    }
}
