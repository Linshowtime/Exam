package com.scau.common.dto.paper;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-01 14:18
 */
@Setter
@Getter
public class AddPaperDto implements Serializable {
    private static final long serialVersionUID = -3843844285713588588L;
    @NotNull(message = "name不能为空")
    private String name;
    @NotNull(message = "gradeId不能为空")
    private Integer gradeId;
    @NotNull(message = "courseId不能为空")
    private Integer courseId;
    private Integer paperTypeId;
    private Integer areaId;
    private Integer periodId;
    private Integer type;
    private Integer selectCount;
    private Integer bankCount;
    private Integer judgeCount;
}
