package com.scau.common.dto.knowledge;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-22 16:03
 */
@Setter
@Getter
public class KnowledgeReqDto implements Serializable {

    private static final long serialVersionUID = -8152725115620270118L;
    private String name;

    private Integer subjectId;

    private Integer notLikeName;//是否模糊查询知识点,默认是模糊查询
}
