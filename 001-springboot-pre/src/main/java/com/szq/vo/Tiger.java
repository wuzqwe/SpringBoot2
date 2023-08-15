package com.szq.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("tiger")
public class Tiger {

    @Value("${tiger.name}")
    private String name;

    @Value("${tiger.age}")
    private Integer age;

    // TODO: 2023/3/17

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
