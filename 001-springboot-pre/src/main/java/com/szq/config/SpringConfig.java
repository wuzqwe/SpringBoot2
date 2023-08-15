package com.szq.config;

import com.szq.vo.Student;
import org.springframework.context.annotation.*;

/**
 * @Configuration:表示当前类是作为配置文件使用的。就是用来配置容器的
 * 位置：在类的上面
 *
 * SpringConfig这个类就相当于bean.xml
 */
@Configuration
@ImportResource(value = "classpath:applicationContext.xml")
@PropertySource(value = "classpath:config.properties")
@ComponentScan(basePackages = "com.szq.vo")
public class SpringConfig {

    /*
    * ，创建方法，方法的返回值是对象。在方法的上面上加入@Bean
    * 方法的返回值对象就注入容器中
    *
    * @Bean:把对象注入到spring容器中。作用相当于<bean>
    * */
    @Bean
    public Student createStudent(){
        Student s1=new Student();
        s1.setName("张三");
        s1.setAge(20);
        s1.setSex("男");
        return s1;
    }

    /***
     * 指定对象在容器中的名称（指定<bean>的id属性）
     * @Bean的name属性，指定对象的名称（id）
     */
    @Bean(name = "lisiStudent")
    public Student makeStudent(){
        Student s2  = new Student();
        s2.setName("李四");
        s2.setAge(22);
        s2.setSex("男");
        return s2;
    }
}
