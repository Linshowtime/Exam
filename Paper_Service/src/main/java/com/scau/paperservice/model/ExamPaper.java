package com.scau.paperservice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@TableName("t_exam_paper")
public class ExamPaper {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer gradeId;

    private Integer courseId;

    private Integer paperTypeId;

    private Integer areaId;

    private Integer periodId;

    private Integer type;

    private Double score;

    private Date createAt;

    private Date updateAt;
}