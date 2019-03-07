package com.scau.common.dto.paper;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-01 14:40
 */
@Getter
@Setter
public class PaperReqDto implements Serializable {
    private static final long serialVersionUID = -2099771408118902697L;
    private Integer id;

    private String name;

    private Integer gradeId;

    private Integer courseId;

    private Integer paperTypeId;

    private Integer areaId;

    private Integer periodId;

    private Integer orgId;

    private Integer state;
}
