package com.scau.common.dto.knowledge;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 更新或查询知识点传输实体
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-20 10:10
 */
@Setter
@Getter
public class UpdateKnowledgeDto implements Serializable {

    private static final long serialVersionUID = -7534161122173963765L;

    @NotBlank(message = "知识点id不能为空")
    private String id;

    private String name;

    private String subjectId;

    private Integer state;
}
