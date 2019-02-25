package com.scau.humanservice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@TableName("t_org")
public class Org {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer status;

    private Date createAt;

    private Date updateAt;
    @TableField(exist = false)
    private Integer notLikeName;//是否模糊查询知识点,默认是模糊查询

}