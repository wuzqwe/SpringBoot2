package com.szq.controller;

import com.szq.model.Student;
import com.szq.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/student/queryStudent")
    @ResponseBody
    public String queryStudent(Integer id){

        Student student = studentService.queryStudentById(id);
        return student.toString();
    }
}
