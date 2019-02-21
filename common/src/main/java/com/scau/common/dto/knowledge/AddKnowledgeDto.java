package com.scau.common.dto.knowledge;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 添加加知识点传输实体
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-20 09:30
 */
@Setter
@Getter
public class AddKnowledgeDto implements Serializable {
    private static final long serialVersionUID = -4915571877413007645L;

    @NotBlank(message = "name不能为空")
    private String name;

    @NotBlank(message = "subjectId不能为空")
    private String subjectId;

}
