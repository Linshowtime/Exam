package com.scau.humanservice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@TableName("t_segement")
@Setter
@Getter
public class Segment {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String segmentname;

    private Integer orderNo;

    private String createPerson;

    private String updatePerson;

    private Date createAt;

    private Date updateAt;

}