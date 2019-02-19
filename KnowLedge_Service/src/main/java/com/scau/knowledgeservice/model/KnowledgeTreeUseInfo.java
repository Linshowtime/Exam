package com.scau.knowledgeservice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@TableName("t_knowledge_tree_use_info")
@Setter
@Getter
public class KnowledgeTreeUseInfo {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String treeId;

    private String orgId;

    private String stageId;

    private String subjectId;

    private Integer type;

    private Date updateDate;

    private Date createDate;

}