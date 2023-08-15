package com.szq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloThymeleafController {

    @GetMapping("/hello")
    public String helloThymeleaf(Model model, HttpServletRequest request){
        request.setAttribute("data","欢迎使用Thymeleaf模板引擎");

        //使用modedl存放对象
        model.addAttribute("mydata","modal中的数据");
        //指定视图(html)
        //逻辑名称
        return "hello";
    }
}
