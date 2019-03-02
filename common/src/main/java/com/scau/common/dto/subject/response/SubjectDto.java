package com.scau.common.dto.subject.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-28 09:40
 */
@Setter
@Getter
public class SubjectDto {
    private Integer id;
    private Integer subjectTypeId;

    private String courseName;

    private Integer courseId;

    private Integer  orgId;

    private String content;

    private String knowledgeName;

    private String knowledgeId;

    private String answer;

    private List<String> optionList;

    private Integer difficulty;

    private String analysis;

    private Byte publish;

    private Integer orderNo;

    private Double score;
}
