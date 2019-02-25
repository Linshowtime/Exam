package com.scau.knowledgeservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class KnowledgeTreeUseInfo {
    private Integer id;

    private String treeId;

    private String orgId;

    private String stageId;

    private String subjectId;

    private Integer type;

    private Date updateDate;

    private Date createDate;

}