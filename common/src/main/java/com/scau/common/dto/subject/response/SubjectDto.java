package com.scau.common.dto.subject.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

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

    private String userAnswer;

    private List<String> optionList;

    private Integer difficulty;

    private String analysis;

    private Byte publish;

    private Integer orderNo;

    private Double score;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectDto that = (SubjectDto) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
