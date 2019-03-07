/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.common.service.human;


import com.scau.common.dto.human.LoginUserDTO;
import com.scau.common.dto.human.RegisterUserDTO;
import com.scau.common.dto.human.UpdateUserDTO;
import com.scau.common.dto.human.student.AddStudentDto;
import com.scau.common.dto.human.student.AuthStudentDto;
import com.scau.common.dto.human.student.StudentDto;
import com.scau.common.dto.human.student.reponse.StudentRepDto;
import com.scau.common.dto.human.teacher.AddTeacherDto;
import com.scau.common.dto.human.teacher.AuthTeacherDto;
import com.scau.common.dto.human.teacher.TeacherDto;
import com.scau.common.dto.human.teacher.reponse.TeacherRepDto;
import com.scau.common.protocol.PageResult;

/**
 * 用户服务接口
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/14 22:09
 */
public interface IUserService {
     /**
      * 注册
      * @param userDTO
      */
     void register( RegisterUserDTO userDTO);

     /**
      *  登录
      * @param userDTO
      * @return
      * 返回1表示已认证，0表示未认证
      */
     Integer login(LoginUserDTO userDTO);

     /**
      * 更新个人信息（包括对用户的逻辑删除）
      * @param userDTO
      */
     void modify(UpdateUserDTO userDTO);

     void addStudent(AddStudentDto studentDto);

     void updateStudent(StudentDto studentDto);

     void authStudent(AuthStudentDto authStudentDto);

     PageResult<StudentRepDto> queryStudent(StudentDto studentDto, Integer pageNo, Integer pageSize);

     void addTeacher(AddTeacherDto teacherDto);

     void updateTeacher(TeacherDto teacherDto);

     PageResult<TeacherRepDto> queryTeacher(TeacherDto teacherDto, Integer pageNo, Integer pageSize);

     void authTeacher(AuthTeacherDto authTeacherDto);

     StudentRepDto findStudentByRegisterNo(String registerNo);

     Integer getOrgIdByRegisterNo(String registerNo);

}
