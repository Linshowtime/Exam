package com.scau.common.dto.paper.reponse;

import com.scau.common.dto.subject.response.SubjectDto;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-06 16:25
 */
@Setter
@Getter
public class ExamResultDto implements Serializable {

    private static final long serialVersionUID = -2171448691229174111L;
    private String paperName;
    private Double score;
    private Double userScore;
    private List<SubjectDto> subjectDtos;
}
