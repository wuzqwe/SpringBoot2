package com.szq.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {

//    学习注解的使用

    //查询id=1001的学生

    /**
     * @PathVariable(路径变量) : 获取url中的数据
     *       属性：value:定义变量的
     *       位置：放在控制器方法放形参前面
     * @return
     */
    @GetMapping("/student/{stuId}")
    public  String queryStudent(@PathVariable(value = "stuId") Integer studetId){
        return "查询学生studentId="+studetId;
    }

    /**
     * 创建资源Post请求
     */
    @PostMapping("/student/{name}/{age}")
    public String createStudent(@PathVariable("name") String name,
                                @PathVariable("age" ) Integer age){
        return "创建资源 student: name="+name+"#age="+age;
    }

    /**
     * 更新资源
     *
     * 当路径变量的名称和形参一样，@PathVariable中的value可以省略
     */
    @PutMapping("/student/{id}/{age}")
    public String modifyStudent(@PathVariable Integer id,@PathVariable Integer age){
        return "更新资源，执行put请求方式：id="+id+"#age="+age;
    }


    /**
     * 删除资源
     */
    @DeleteMapping("/student/{id}")
    public String removeStudentBy(@PathVariable Integer id){
        return "删除资源，执行delete id="+id;
    }

    @PostMapping("/student/test")
    public String test(){
        return "执行student/test,使用的请求方式 post";
    }

}
