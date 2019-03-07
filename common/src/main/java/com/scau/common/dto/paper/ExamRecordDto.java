package com.scau.common.dto.paper;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-04 20:06
 */
@Getter
@Setter
public class ExamRecordDto implements Serializable {
    private static final long serialVersionUID = 1130487593079888530L;
    private Integer paperId;
    private Integer classId;
    private Date startTime;
    private Date endTime;
    private Integer totalTime;
}
