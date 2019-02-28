package com.scau.knowledgeservice.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@TableName("t_knowledge")
public class Knowledge {
    private String id;

    private String name;

    private Integer subjectId;

    private Date createDate;

    private Date updateDate;

    private Integer deleteFlag;

    private Integer state;

    private Integer notLikeName;//是否模糊查询知识点,默认是模糊查询

}