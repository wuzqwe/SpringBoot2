package com.szq;

import com.szq.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        UserServiceImpl userService = ctx.getBean("userService", UserServiceImpl.class);

       userService.sayHello("张三");
    }

}
