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
 * @date 2019-03-01 23:51
 */
@Getter
@Setter
public class SubjectExamDto implements Serializable {
    private static final long serialVersionUID = -6608904894133878896L;
    private Integer id;
    @NotNull(message = "examPaperId不能为空")
    private Integer examPaperId;
    @NotNull(message = "subjectId不能为空")
    private Integer subjectId;

    private Integer orderNo;

    private Double score;

}
