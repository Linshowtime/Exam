package com.scau.subjectservice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@TableName("t_subject")
public class Subject {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer subjectTypeId;

    private Integer courseId;

    private Integer orgId;

    private String content;

    private String knowledgeId;

    private String answer;

    private String choice1;

    private String choice2;

    private String choice3;

    private String choice4;

    private Integer difficulty;

    private String analysis;

    private String creator;

    private Date createAt;

    private Date updateAt;

    private Byte publish;

}