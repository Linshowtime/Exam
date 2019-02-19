package com.scau.knowledgeservice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@TableName("t_knowledge_tree_relation")
@Setter
@Getter
public class KnowledgeTreeRelation {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String treeId;

    private String knowledgeId;

    private String parentId;

    private Integer orderNo;

    private Date createDate;

    private Date updateDate;

    private Integer leaf;

    private Integer level;

    private String path;
}