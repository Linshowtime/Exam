package com.scau.common.dto.human.student;

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
 * @date 2019-02-21 19:53
 */
@Setter
@Getter
public class AddStudentDto implements Serializable {
    private static final long serialVersionUID = -8530011355789553047L;
    @NotNull(message = "studentNo不能为空")
    private String studentNo;
    @NotBlank(message = "name不能为空")
    private String name;
    private Integer studentId;
    private Integer classId;
    @NotNull(message = "orgId不能为空")
    private Integer orgId;
}
