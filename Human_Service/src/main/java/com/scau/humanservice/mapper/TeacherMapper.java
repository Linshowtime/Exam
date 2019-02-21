package com.scau.humanservice.mapper;

import com.scau.humanservice.model.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer teacherNo);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teacherNo);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}