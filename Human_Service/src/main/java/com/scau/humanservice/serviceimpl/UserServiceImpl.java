/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.humanservice.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.scau.common.dto.human.LoginUserDTO;
import com.scau.common.dto.human.RegisterUserDTO;
import com.scau.common.dto.human.UpdateUserDTO;
import com.scau.common.enums.RoleEnum;
import com.scau.common.exception.ExceptionCode;
import com.scau.common.exception.bussiness.InvalidUserException;
import com.scau.common.service.human.IUserService;
import com.scau.humanservice.mapper.UserMapper;
import com.scau.humanservice.model.User;
import com.scau.humanservice.util.DESUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void register(  RegisterUserDTO userDTO) {
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
    public Boolean login(LoginUserDTO userDTO) {
      User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getRegisterNo,userDTO.getRegisterNo()).
              eq(User::getRole,RoleEnum.getName(userDTO.getRole())).eq(User::getStatus,0));
      if (user != null){
          if (DESUtils.decryptBasedDes(user.getPassword()).equals(userDTO.getPassword())){
              return true;
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
        int result = userMapper.update(user,new LambdaQueryWrapper<User>().eq(User::getRegisterNo,user.getRegisterNo()));
        if (result==0){
            throw new InvalidUserException(ExceptionCode.UPDATE_FAIL);
        }
    }
}
