package com.scau.common.dto.subject;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-28 10:04
 */
@Getter
@Setter
public class SubjectReqDto {
    private Integer id;
    private Integer subjectTypeId;

    private Integer courseId;

    private Integer orgId;

    private String content;

    private String knowledgeId;

    private Integer difficulty;

    private Byte publish;
}
