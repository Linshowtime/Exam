package com.scau.common.dto.human;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-27 09:14
 */
@Setter
@Getter
public class SegmentDto implements Serializable {
    private static final long serialVersionUID = 5088093347811783226L;
    private Integer id;

    private String name;

}
