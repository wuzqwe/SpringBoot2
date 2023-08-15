package com.szq.config;

import com.szq.web.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

@Configuration
public class webApplicationConfig {

    //定义方法，注册Servlet对象
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){

        //public ServletRegistrationBean(T servlet, String... urlMappings)
        //第一个参数是Servlet对象，第二个是url地址

      /*  ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet(),
                "/myservlet");
*/


        ServletRegistrationBean<Servlet> bean = new ServletRegistrationBean<>();
        bean.setServlet(new MyServlet());
        bean.addUrlMappings("/login","/test");
        return bean;
    }

}
