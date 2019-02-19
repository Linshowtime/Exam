package com.scau.knowledgeservice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@TableName("t_knowledge_tree")
@Setter
@Getter
public class KnowledgeTree {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private String subjectId;

    private Integer status;

    private String orgId;

    private Date createDate;

    private Date updateDate;
}