/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.common.service.human;


import com.scau.common.dto.human.LoginUserDTO;
import com.scau.common.dto.human.RegisterUserDTO;
import com.scau.common.dto.human.UpdateUserDTO;

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
      */
     Boolean login(LoginUserDTO userDTO);

     /**
      * 更新个人信息（包括对用户的逻辑删除）
      * @param userDTO
      */
     void modify(UpdateUserDTO userDTO);
}
