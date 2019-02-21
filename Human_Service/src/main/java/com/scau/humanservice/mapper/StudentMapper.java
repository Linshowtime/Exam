package com.scau.humanservice.mapper;

import com.scau.humanservice.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentNo);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentNo);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}