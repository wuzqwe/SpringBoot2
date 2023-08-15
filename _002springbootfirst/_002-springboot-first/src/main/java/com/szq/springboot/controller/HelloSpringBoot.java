package com.szq.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloSpringBoot {

    @RequestMapping("/hello")
    @ResponseBody
    public String helloSpringBoot(){
        return "欢迎使用SpringBoot框架";
    }

    @RequestMapping("/hre")
    @ResponseBody
    public String doSome(){
    return "hello SpringBoot应用 设置了端口";
    }
}
