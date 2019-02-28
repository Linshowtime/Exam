package com.scau.common.dto.human.student.reponse;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-26 10:29
 */
@Setter
@Getter
public class StudentRepDto implements Serializable {
    private static final long serialVersionUID = 8849515796127206611L;
    private String studentNo;
    private String name;
    private String orgName;
    private Integer state;
}
