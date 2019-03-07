package com.scau.paperservice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@TableName("t_exam_record")
public class ExamRecord {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer paperId;

    private String studentNo;

    private String startTime;

    private String endTime;

    private Integer totalTime;

    private Double score;

    private Integer state;

}