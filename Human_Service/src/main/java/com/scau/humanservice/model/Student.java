package com.scau.humanservice.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@TableName("t_student")
@Setter
@Getter
public class Student {
    private String studentNo;

    private Integer studentId;

    private Integer classId;

    private Integer orgId;

    private Integer authStatus;

    private String name;

    private Integer state;

}