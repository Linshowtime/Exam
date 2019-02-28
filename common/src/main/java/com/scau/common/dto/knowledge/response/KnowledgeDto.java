package com.scau.common.dto.knowledge.response;

import lombok.Getter;
import lombok.Setter;

/**
 * 返回知识点内容传输实体
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-20 10:12
 */
@Setter
@Getter
public class KnowledgeDto {
    private String id;

    private String name;

    private Integer subjectId;

    private Integer deleteFlag;

    private Integer state;
}
