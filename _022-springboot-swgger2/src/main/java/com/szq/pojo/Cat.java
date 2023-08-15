package com.szq.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "猫的实体类")
public class Cat {

    @ApiModelProperty(value = "猫的名字")
    private String name;

    @ApiModelProperty(value = "猫的年龄")
    private Long age;

    public Cat(String name, Long age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
