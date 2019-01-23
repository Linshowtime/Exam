/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.humanservice.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.scau.common.dto.human.UserDTO;
import com.scau.common.exception.ExceptionCode;
import com.scau.common.exception.bussiness.InvalidParameterException;
import com.scau.common.service.human.IUserService;
import com.scau.humanservice.mapper.UserMapper;
import com.scau.humanservice.model.User;
import com.scau.humanservice.util.DESUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/14 22:34
 */
@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {
   @Autowired
   private  UserMapper userMapper;
    public void register(  UserDTO userDTO) {
       Wrapper<User> wrapper = new QueryWrapper<User>().eq("register_no",userDTO.getRegisterNo()).
                                    or().eq("phone",userDTO.getPhone());
       List<User> result = userMapper.selectList(wrapper);
       result.stream().forEach(user -> {
           if(user.getRegisterNo() != null && user.getRegisterNo().equals(userDTO.getRegisterNo())){
               throw new InvalidParameterException(ExceptionCode.EXIST_REGISTER_NO_ERROR);
           }
           else if(user.getPhone() != null && user.getPhone().equals(userDTO.getPhone())){
               throw  new InvalidParameterException(ExceptionCode.EXIST_PHONE);
           }
       });
       User user = new User();
       BeanUtils.copyProperties(userDTO,user);
       user.setPassword(DESUtils.encryptBasedDes(user.getPassword()));
       userMapper.insert(user);
    }
}
