package com.scau.humanservice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@TableName("t_user")
@Setter
@Getter
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String registerNo;

    private String password;

    private Integer gender;

    private String phone;

    private String role;

    private Integer status;

    private Date createAt;

    private Date updateAt;

}