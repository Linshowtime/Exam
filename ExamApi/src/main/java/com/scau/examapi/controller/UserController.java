/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.examapi.controller;

import com.scau.common.dto.human.UserDTO;
import com.scau.common.service.human.IUserService;
import com.scau.examapi.net.Result;
import com.scau.examapi.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * TODO
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
    public Result register( @RequestBody UserDTO userDTO) {
            iUserService.register(userDTO);
            return ResultUtil.success(null);
        }
    }

