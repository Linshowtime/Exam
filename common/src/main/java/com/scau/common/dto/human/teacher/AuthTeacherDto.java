package com.scau.common.dto.human.teacher;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-26 16:18
 */
@Getter
@Setter
public class AuthTeacherDto implements Serializable {
    private static final long serialVersionUID = -3505217047407048552L;
    @NotNull(message = "账号不能为空")
    private String registerNo;
    @NotNull(message = "工号不能为空")
    private String teacherNo;
}
