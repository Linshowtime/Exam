package com.scau.humanservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scau.humanservice.model.Student;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
    List<Student> queryStudent(Student student);
}