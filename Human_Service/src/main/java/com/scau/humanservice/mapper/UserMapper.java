package com.scau.humanservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scau.humanservice.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {
   User test(@Param("id") Integer id);
}