package com.szq.test;

import com.szq.config.SpringConfig;
import com.szq.vo.Cat;
import com.szq.vo.Student;
import com.szq.vo.Tiger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test01() {
        String config="bean.xml";
        ApplicationContext cx=new ClassPathXmlApplicationContext(config);
        Student myStudent = cx.getBean("myStudent", Student.class);
        System.out.println("容器中的对象："+myStudent);
    }

    @Test
    public void test02() {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        Student st = ctx.getBean("createStudent", Student.class);
        System.out.println(st);
    }

    @Test
    public void test03() {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        Student st = ctx.getBean("lisiStudent", Student.class);
        System.out.println(st);
    }

    @Test
    public void test04() {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        Cat myCat = ctx.getBean("myCat", Cat.class);
        System.out.println(myCat);
    }

    @Test
    public void test05() {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        Tiger tiger = ctx.getBean("tiger", Tiger.class);
        System.out.println(tiger);
    }
}
