package com.scau.humanservice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@TableName("t_grade")
public class Grade {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String gradename;

    private Integer segmentId;

    private String createPerson;

    private String updatePerson;

    private Date createAt;

    private Date updateAt;
}