package com.szq.service.impl;

import com.szq.dao.StudentDao;
import com.szq.model.Student;
import com.szq.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public Student queryStudentById(Integer id) {
        return studentDao.selectById(id);
    }
}
