package com.scau.paperservice.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@TableName("t_exam_type")
public class ExamType {
    private Integer id;

    private String name;

    private Integer orderNo;
}