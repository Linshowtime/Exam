package com.scau.common.dto.human;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-22 08:58
 */
@Getter
@Setter
public class CourseDto implements Serializable {
    private static final long serialVersionUID = -4884289240604199692L;
    private Integer id;
    private String name;
}
