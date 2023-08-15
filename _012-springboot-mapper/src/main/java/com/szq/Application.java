package com.szq;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @MapperScan:找到Dao接口和Mapper文件
 * basePackage:dao接口所在的包名
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.szq.dao","com.szq.mapper"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
