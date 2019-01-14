/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.humanservice.serviceimpl;

import com.scau.common.dto.human.UserDTO;
import com.scau.common.service.human.IUserService;
import com.scau.humanservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
   private UserMapper userMapper;
   @Transactional
    public boolean register(UserDTO userDTO) {

        return false;
    }
}
