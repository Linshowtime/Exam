package com.scau.knowledgeservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class KnowledgeTreeRelation {
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