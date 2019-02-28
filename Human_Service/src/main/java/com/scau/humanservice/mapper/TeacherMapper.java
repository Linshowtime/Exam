package com.scau.humanservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scau.humanservice.model.Teacher;

import java.util.List;

public interface TeacherMapper extends BaseMapper<Teacher> {
    List<Teacher> queryTeacher(Teacher teacher);
}