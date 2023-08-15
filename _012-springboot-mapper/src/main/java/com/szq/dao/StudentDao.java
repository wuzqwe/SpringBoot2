package com.szq.dao;

import com.szq.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 *@Mapper 告诉Mybatis这是dao接口，新创建此接口的代理对象
 *      位置：在类的上面
 */
/*@Mapper*/
public interface StudentDao {

    Student selectById(@Param("stuId") Integer id);

}
