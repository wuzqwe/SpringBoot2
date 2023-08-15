package com.szq.service.impl;

import com.szq.dao.StudentMapper;
import com.szq.model.Student;
import com.szq.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    /**
     * @Transactional 表示方法的有事务的支持
     *      默认：使用库的隔离级别 REQUIRED 传播行为： 超时时间 -1
     *      抛出运行时异常时，回滚事务
     * @param student
     * @return
     */
    @Transactional
    @Override
    public int addStudent(Student student) {
        System.out.println("业务方法的addStudent");
        int rows = studentMapper.insertBy(student);

        //抛出异常，目的是回滚事务
//        int m=10/0;

        return rows;
    }
}
