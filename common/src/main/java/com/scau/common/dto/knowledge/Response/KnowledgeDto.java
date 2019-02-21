package com.scau.common.dto.knowledge.Response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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

    private String subjectId;

    private Integer deleteFlag;

    private Integer state;
}
