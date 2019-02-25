package com.scau.knowledgeservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class KnowledgeTree {
    private Integer id;

    private String name;

    private String subjectId;

    private Integer status;

    private String orgId;

    private Date createDate;

    private Date updateDate;
}