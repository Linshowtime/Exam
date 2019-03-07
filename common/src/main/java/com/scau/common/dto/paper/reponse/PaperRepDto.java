package com.scau.common.dto.paper.reponse;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-01 14:23
 */
@Setter
@Getter
public class PaperRepDto implements Serializable {
    private static final long serialVersionUID = 8638060825049654121L;
    private Integer id;
    private String createDate;
    private String name;
    private String paperTypeName;
    private Double score;
    private Integer type;
    private Integer state;
}
