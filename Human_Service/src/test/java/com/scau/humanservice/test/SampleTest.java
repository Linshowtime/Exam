/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.humanservice.test;

import com.scau.common.dto.human.CourseDto;
import com.scau.common.dto.human.RegisterUserDTO;
import com.scau.common.dto.human.org.OrgReqDto;
import com.scau.common.dto.human.student.StudentDto;
import com.scau.common.service.human.ICourseService;
import com.scau.common.service.human.IOrgService;
import com.scau.common.service.human.IUserService;
import com.scau.humanservice.mapper.UserMapper;
import com.scau.humanservice.model.Course;
import com.scau.humanservice.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/17 21:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private ICourseService courseService;
   @Autowired
   private IUserService mapper;
   @Autowired
   private IOrgService iOrgService;
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<CourseDto> userList = courseService.getAllCourse();
        Assert.assertEquals(9, userList.size());
        System.out.print(userList);
    }

    @Test
    public void testSelect1() {
        System.out.println(("----- insert method test ------"));
        RegisterUserDTO user = new RegisterUserDTO();
        user.setPassword("123456");
        user.setRegisterNo("James");
        user.setPhone("13534538114");
        user.setRole(0);
         mapper.register(user);
        RegisterUserDTO user1 = new RegisterUserDTO();
        user1.setPassword("123456");
        user1.setRegisterNo("Jackson");
        user1.setPhone("18948442882");
        user1.setRole(1);
        mapper.register(user1);
    }
    @Test
    public void testInsertOrg() {
        System.out.println(("----- testInsertOrg method test ------"));
        OrgReqDto orgReqDto = new OrgReqDto();
        orgReqDto.setName("华农附小");
        iOrgService.insert(orgReqDto);
    }
    @Test
    public void testselectStudent() {
        System.out.println(("----- testInsertOrg method test ------"));
       mapper.queryStudent(new StudentDto(),1,5);

    }


}