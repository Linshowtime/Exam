package com.scau.common.dto.human.teacher;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-21 20:25
 */
@Getter
@Setter
public class AddTeacherDto implements Serializable {
    private static final long serialVersionUID = -5106165485328152522L;
    @NotNull(message = "teacherNo不能为空")
    private String teacherNo;
    @NotBlank(message = "name不能为空")
    private String name;
    private Integer teacherId;
    @NotNull(message = "courseId不能为空")
    private Integer courseId;
    @NotNull(message = "orgId不能为空")
    private Integer orgId;
}
