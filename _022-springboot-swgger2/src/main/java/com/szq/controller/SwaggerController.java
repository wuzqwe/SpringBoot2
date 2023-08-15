package com.szq.controller;

import com.szq.pojo.Cat;
import com.szq.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swagger")
@Api(value = "Swagger2 在线接口文档")
public class SwaggerController {

    @GetMapping("/get/{id}")
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    public User getUserId(@PathVariable @ApiParam(value = "用户") Long id){

        User user = new User(id,"szq","123456");

        return user;
    }

    @GetMapping("/we/{name}")
    @ApiOperation(value = "根据名字获取猫的信息")
    public Cat getCatId(@PathVariable @ApiParam(value = "名字") String name){
        Cat cat = new Cat(name,10L);
        return cat;
    }
}
