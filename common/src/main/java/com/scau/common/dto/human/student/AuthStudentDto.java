package com.scau.common.dto.human.student;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-26 16:21
 */
@Setter
@Getter
public class AuthStudentDto implements Serializable {

    private static final long serialVersionUID = 1655406286650036431L;
    @NotNull(message = "账号不能为空")
    private String registerNo;
    @NotNull(message = "学号不能为空")
    private String studentNo;
}
