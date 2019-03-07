package com.scau.paperservice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@TableName("t_record_answer")
public class RecordAnswer {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer recordId;

    private Integer subjectId;

    private String answer;

    private String result;
}