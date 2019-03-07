package com.scau.common.dto.human.TClass;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-03 23:19
 */
@Getter
@Setter
public class ClassDto implements Serializable {
    private static final long serialVersionUID = 63045710331810124L;
    private Integer id;
    @NotNull(message = "className不能为空")
    private String className;
    @NotNull(message = "tRegisterNo不能为空")
    private String registerNo;
}
