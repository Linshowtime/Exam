/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.examapi.controller.Human;

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
import com.scau.common.service.human.IUserService;
import com.scau.examapi.net.Result;
import com.scau.examapi.util.JwtUtils;
import com.scau.examapi.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 用户相关应用层接口
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/16 23:16
 */
@Api(value = "Human", description = "人力资源相关接口")
@RestController
@RequestMapping("/human/user/api")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public Result register( @RequestBody RegisterUserDTO userDTO) {
            iUserService.register(userDTO);
            return ResultUtil.success(null);
        }
    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public Result login(@RequestBody LoginUserDTO userDTO) {
        Integer result =  iUserService.login(userDTO);
        HashMap<String, Object> map = new HashMap<String, Object>();
        String token = JwtUtils.encode(userDTO, 6000 * 1000 * 60 * 2);
        if(result==1) {
            map.put("auth", 1);
        }else {
            map.put("auth",0);
        }
        map.put("token",token);
        map.put("registerNo",userDTO.getRegisterNo());
        return ResultUtil.success(map);
    }
    @ApiOperation(value = "修改用户信息(包括逻辑删除)")
    @PostMapping("/modify")
    public Result modify(@RequestBody UpdateUserDTO userDTO) {
        iUserService.modify(userDTO);
        return ResultUtil.success(null);
    }

    @ApiOperation(value = "添加学生")
    @PostMapping("/addStudent")
    public Result addStudent(@RequestBody AddStudentDto addStudentDto) {
        iUserService.addStudent(addStudentDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "修改学生")
    @PostMapping("/updateStudent")
    public Result updateStudent(@RequestBody StudentDto studentDto) {
        iUserService.updateStudent(studentDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "学生认证")
    @PostMapping("/authStudent")
    public Result authStudent(@RequestBody AuthStudentDto studentDto) {
        iUserService.authStudent(studentDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "分页查询学生")
    @PostMapping("/query/student/{pageNo}/{pageSize}")
    public Result queryStudent(@RequestBody StudentDto studentDto, @PathVariable Integer pageNo, @PathVariable Integer pageSize) {
       PageResult<StudentRepDto> studentRepDtoPageResult =iUserService.queryStudent(studentDto,pageNo,pageSize);
        return ResultUtil.success(studentRepDtoPageResult);
    }

    @ApiOperation(value = "添加教师")
    @PostMapping("/addTeacher")
    public Result addTeacher(@RequestBody AddTeacherDto addTeacherDto) {
        iUserService.addTeacher(addTeacherDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "修改教师")
    @PostMapping("/updateTeacher")
    public Result updateTeacher(@RequestBody TeacherDto teacherDto) {
        iUserService.updateTeacher(teacherDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "教师认证")
    @PostMapping("/authTeacher")
    public Result authTeacher(@RequestBody AuthTeacherDto teacherDto) {
        iUserService.authTeacher(teacherDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "分页查询教师")
    @PostMapping("/query/teacher/{pageNo}/{pageSize}")
    public Result queryTeacher(@RequestBody TeacherDto teacherDto, @PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        PageResult<TeacherRepDto> teacherRepDtoPageResult =iUserService.queryTeacher(teacherDto,pageNo,pageSize);
        return ResultUtil.success(teacherRepDtoPageResult);
    }
    @ApiOperation(value = "根据账号获取学校id")
    @GetMapping("/orgId/{registerNo}")
    public Result queryOrgId(  @PathVariable String registerNo) {
        return ResultUtil.success(iUserService.getOrgIdByRegisterNo(registerNo));
    }
}

