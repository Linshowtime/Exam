package com.scau.common.dto.human.student;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-26 10:36
 */
@Setter
@Getter
public class StudentDto implements Serializable {
    private static final long serialVersionUID = -8771155013193877892L;
    private String studentNo;
    private String name;
    private Integer studentId;
    private Integer classId;
    private Integer orgId;
    private Integer state;
}
