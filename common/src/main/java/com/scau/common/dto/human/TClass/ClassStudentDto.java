package com.scau.common.dto.human.TClass;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-04 08:29
 */
@Setter
@Getter
public class ClassStudentDto implements Serializable {
    private static final long serialVersionUID = -7029451094725711687L;
    private Integer classId;
    private String studentNo;
}
