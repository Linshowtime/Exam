package com.scau.common.dto.human.teacher.reponse;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-26 15:15
 */
@Setter
@Getter
public class TeacherRepDto implements Serializable {
    private static final long serialVersionUID = -3202308316735783808L;
    private String orgName;
    private String courseName;
    private String name;
    private String teacherNo;
    private Integer state;
    private Integer orgId;
}
