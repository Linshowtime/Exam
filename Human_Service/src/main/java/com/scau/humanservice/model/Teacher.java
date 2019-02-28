package com.scau.humanservice.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@TableName("t_teacher")
@Setter
@Getter
public class Teacher {
    private String teacherNo;

    private Integer teacherId;

    private Integer courseId;

    private Integer orgId;

    private Integer authStatus;

    private String name;

    private Integer state;
}