/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.humanservice.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
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
import com.scau.common.enums.RoleEnum;
import com.scau.common.exception.ExceptionCode;
import com.scau.common.exception.bussiness.InvalidUserException;
import com.scau.common.protocol.PageResult;
import com.scau.common.service.human.IUserService;
import com.scau.humanservice.mapper.*;
import com.scau.humanservice.model.*;
import com.scau.humanservice.util.DESUtils;
import com.scau.humanservice.util.PageResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;


/**
 * 用户服务接口实现类
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/14 22:34
 */
@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {
   @Autowired
   private  UserMapper userMapper;
   @Autowired
   private TeacherMapper teacherMapper;
   @Autowired
   private StudentMapper studentMapper;
   @Autowired
   private OrgMapper orgMapper;
   @Autowired
   private CourseMapper courseMapper;
    public void register(RegisterUserDTO userDTO) {
       Wrapper<User> wrapper = new QueryWrapper<User>().eq("register_no",userDTO.getRegisterNo()).
                                    or().eq("phone",userDTO.getPhone()).eq("status",0);
       List<User> result = userMapper.selectList(wrapper);
       result.stream().forEach(user -> {
           if(user.getRegisterNo() != null && user.getRegisterNo().equals(userDTO.getRegisterNo())){
               throw new InvalidUserException(ExceptionCode.EXIST_REGISTER_NO_ERROR);
           }
           else if(user.getPhone() != null && user.getPhone().equals(userDTO.getPhone())){
               throw  new InvalidUserException(ExceptionCode.EXIST_PHONE);
           }
       });
       User user = new User();
       BeanUtils.copyProperties(userDTO,user);
       user.setRole(RoleEnum.getName(userDTO.getRole()));
       user.setPassword(DESUtils.encryptBasedDes(user.getPassword()));
       userMapper.insert(user);
    }
    @Override
    public Integer login(LoginUserDTO userDTO) {
      User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getRegisterNo,userDTO.getRegisterNo()).
              eq(User::getRole,RoleEnum.getName(userDTO.getRole())).eq(User::getStatus,0));
      if (user != null){
          if (DESUtils.decryptBasedDes(user.getPassword()).equals(userDTO.getPassword())){
              if (RoleEnum.TEACHER.getIndex().equals(userDTO.getRole())){
                  if(teacherMapper.selectOne(new QueryWrapper<Teacher>().eq("teacher_id",user.getId()).eq("state",0))!=null){
                      return 1;
                  }
                  return 0;
              }
              if (RoleEnum.STUDENT.getIndex().equals(userDTO.getRole())){
                  if(studentMapper.selectOne(new QueryWrapper<Student>().eq("student_id",user.getId()).eq("state",0))!=null){
                      return 1;
                  }
                  return 0;
              }
              return 0;

          }
          else {
              throw new InvalidUserException(ExceptionCode.ERROR_PASSWORD);
          }
      }
      else {
          throw new InvalidUserException(ExceptionCode.ERROR_REGISTER);
      }
    }

    @Override
    public void modify(UpdateUserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        if(user.getPassword()!=null){
            user.setPassword(DESUtils.encryptBasedDes(user.getPassword()));
        }
        int result = userMapper.update(user,new LambdaQueryWrapper<User>().eq(User::getRegisterNo,user.getRegisterNo()));
        if (result==0){
            throw new InvalidUserException(ExceptionCode.UPDATE_FAIL);
        }
    }

    @Override
    public void addStudent(AddStudentDto studentDto) {
    Student student= studentMapper.selectOne(new QueryWrapper<Student>().eq("student_no",studentDto.getStudentNo())
                    .eq("org_id",studentDto.getOrgId()));
    if(student!=null){
        throw new InvalidUserException(ExceptionCode.EXIST_STUDENT);
    }
    Student s = new Student();
    BeanUtils.copyProperties(studentDto,s);
    studentMapper.insert(s);
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
    Student student = new Student();
    BeanUtils.copyProperties(studentDto,student);
    studentMapper.update(student,new QueryWrapper<Student>().eq("student_no",student.getStudentNo()));
}

    @Override
    public void authStudent(AuthStudentDto authStudentDto) {
      Integer studentId = userMapper.selectOne(new QueryWrapper<User>().eq("register_no",
                           authStudentDto.getRegisterNo())).getId();
        Student student = new Student();
        student.setAuthStatus(1);
        student.setStudentId(studentId);
       int record = studentMapper.update(student,new QueryWrapper<Student>().eq("student_no",authStudentDto.getStudentNo()));
       if(record==0){
           throw new InvalidUserException(ExceptionCode.INVALID_AUTH);
       }
    }

    @Override
    public PageResult<StudentRepDto> queryStudent(StudentDto studentDto, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        List<Student> students= studentMapper.queryStudent(student);
        List<StudentRepDto> studentRepDtos = new ArrayList<>(students.size());
        students.stream().forEach(e->{
            StudentRepDto studentRepDto = new StudentRepDto();
            BeanUtils.copyProperties(e,studentRepDto);
            String orgName = orgMapper.selectOne(new QueryWrapper<Org>().eq("id",e.getOrgId())).getName();
          if(orgName != null) {
            studentRepDto.setOrgName(orgName);
        }
            studentRepDtos.add(studentRepDto);
        });
        return PageResultUtil.convertPageBean(students,studentRepDtos);
    }

    @Override
    public void addTeacher(AddTeacherDto teacherDto) {
        Teacher teacher= teacherMapper.selectOne(new QueryWrapper<Teacher>().eq("teacher_no",teacherDto.getTeacherNo())
                .eq("org_id",teacherDto.getOrgId()));
        if(teacher!=null){
            throw new InvalidUserException(ExceptionCode.EXIST_TEACHER);
        }
        Teacher s = new Teacher();
        BeanUtils.copyProperties(teacherDto,s);
        teacherMapper.insert(s);
    }

    @Override
    public void updateTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherDto,teacher);
        teacherMapper.update(teacher,new QueryWrapper<Teacher>().eq("teacher_no",teacher.getTeacherNo()));
    }
    @Override
    public PageResult<TeacherRepDto> queryTeacher(TeacherDto teacherDto, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherDto,teacher);
        List<Teacher> teachers= teacherMapper.queryTeacher(teacher);
        List<TeacherRepDto> teacherRepDtos = new ArrayList<>(teachers.size());
        teachers.stream().forEach(e->{
            TeacherRepDto teacherRepDto = new TeacherRepDto();
            BeanUtils.copyProperties(e,teacherRepDto);
            String orgName = orgMapper.selectOne(new QueryWrapper<Org>().eq("id",e.getOrgId())).getName();
            if(orgName != null) {
                teacherRepDto.setOrgName(orgName);
            }
            String courseName = courseMapper.selectOne(new QueryWrapper<Course>().eq("id",e.getCourseId())).getCoursename();
            if(courseName != null){
                teacherRepDto.setCourseName(courseName);
            }
            teacherRepDtos.add(teacherRepDto);
        });
        return PageResultUtil.convertPageBean(teachers,teacherRepDtos);
    }

    @Override
    public void authTeacher(AuthTeacherDto authTeacherDto) {
        Integer teacherId = userMapper.selectOne(new QueryWrapper<User>().eq("register_no",
                authTeacherDto.getRegisterNo())).getId();
        Teacher teacher = new Teacher();
        teacher.setAuthStatus(1);
        teacher.setTeacherId(teacherId);
       int record = teacherMapper.update(teacher,new QueryWrapper<Teacher>().eq("teacher_no",authTeacherDto.getTeacherNo()));
       if(record==0){
           throw new InvalidUserException(ExceptionCode.INVALID_AUTH);
       }
    }

    @Override
    public StudentRepDto findStudentByRegisterNo(String registerNo) {
       User user= userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getRegisterNo,registerNo));
       Student student = studentMapper.selectOne(new LambdaQueryWrapper<Student>().eq(Student::getStudentId,user.getId()));
        StudentRepDto studentRepDto = new StudentRepDto();
        BeanUtils.copyProperties(student,studentRepDto);
        return studentRepDto;
    }

    @Override
    public Integer getOrgIdByRegisterNo(String registerNo) {
        User user= userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getRegisterNo,registerNo));
        Student student = studentMapper.selectOne(new LambdaQueryWrapper<Student>().eq(Student::getStudentId,user.getId()));
        if(student!=null){
           return student.getOrgId();
        }
       else{
         return teacherMapper.selectOne(new LambdaQueryWrapper<Teacher>().eq(Teacher::getTeacherId,user.getId())).getOrgId();
        }
    }
}
