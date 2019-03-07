package com.scau.common.dto.paper.reponse;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-04 22:58
 */
@Setter
@Getter
public class ExamRecordRepDto implements Serializable {
    private static final long serialVersionUID = -2912661330132084709L;
    private Integer id;

    private Integer paperId;

    private String studentNo;

    private String StudentName;

    private String paperName;

    private String startTime;

    private String endTime;

    private Integer totalTime;

    private Double score;

    private Integer state;
}
