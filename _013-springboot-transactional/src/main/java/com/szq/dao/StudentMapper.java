package com.szq.dao;

import com.szq.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student row);

    int insertSelective(Student row);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student row);

    int updateByPrimaryKey(Student row);

    int insertBy(Student student);
}