package com.scau.common.dto.subject;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-28 09:28
 */
@Getter
@Setter
public class AddSubjectDto {
    private Integer id;
    @NotNull(message = "subjectTypeId不能为空")
    private Integer subjectTypeId;

    @NotNull(message = "courseId不能为空")
    private Integer courseId;
    @NotNull(message = "orgId不能为空")
    private Integer orgId;

    @NotBlank(message = "content不能为空")
    private String content;

    @NotNull(message = "knowledgeId不能为空")
    private String  knowledgeId;

    @NotBlank(message = "answer不能为空")
    private String answer;

    private String choice1;

    private String choice2;

    private String choice3;

    private String choice4;

    @NotNull(message = "difficulty不能为空")
    private Integer difficulty;

    @NotBlank(message = "analysis不能为空")
    private String analysis;

    private String creator;

    private Byte publish;
}
