package com.scau.common.dto.paper;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-05 08:45
 */
@Setter
@Getter
public class ExamReqDto implements Serializable {

    private static final long serialVersionUID = 7903223420302346088L;

    private Integer paperId;

    private String registerNo;

    private Integer type;//0表示教师，1表示学生
}
