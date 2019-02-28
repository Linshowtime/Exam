package com.scau.common.dto.human.teacher;

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
public class TeacherDto implements Serializable {
    private static final long serialVersionUID = -8414844391344432276L;
    private String teacherNo;
    private String name;
    private Integer teacherId;
    private Integer courseId;
    private Integer orgId;
    private Integer state;
}
