package com.scau.paperservice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@TableName("t_subject_exam_rel")
public class SubjectExamRel {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer examPaperId;

    private Integer subjectId;

    private Integer orderNo;

    private Double score;

    private Date createDate;

    private Date updateDate;

}