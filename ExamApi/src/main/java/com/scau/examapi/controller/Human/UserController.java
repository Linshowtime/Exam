/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.examapi.controller.Human;

import com.scau.common.dto.human.LoginUserDTO;
import com.scau.common.dto.human.RegisterUserDTO;
import com.scau.common.dto.human.UpdateUserDTO;
import com.scau.common.service.human.IUserService;
import com.scau.examapi.net.Result;
import com.scau.examapi.util.JwtUtils;
import com.scau.examapi.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
       Boolean result =  iUserService.login(userDTO);
        HashMap<String, Object> map = new HashMap<String, Object>();
       if(result){
           String token = JwtUtils.encode(userDTO, 6000 * 1000 * 60 * 2);
        map.put("token",token);
        map.put("registerNo",userDTO.getRegisterNo());
       }
        return ResultUtil.success(map);
    }
    @ApiOperation(value = "修改用户信息(包括逻辑删除)")
    @PostMapping("/modify")
    public Result modify(@RequestBody UpdateUserDTO userDTO) {
         iUserService.modify(userDTO);
        return ResultUtil.success(null);
    }
    }

