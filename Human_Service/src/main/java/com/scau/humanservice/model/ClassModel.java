package com.scau.humanservice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@TableName("t_class")
public class ClassModel {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String className;

    private String tRegisterNo;

    private String createPerson;

    private String updatePerson;

    private Date createAt;

    private Date updateAt;

}