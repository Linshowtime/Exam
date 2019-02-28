package com.scau.subjectservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scau.subjectservice.model.Subject;

import java.util.List;

public interface SubjectMapper extends BaseMapper<Subject> {
       List<Subject> querySubject(Subject subject);
}