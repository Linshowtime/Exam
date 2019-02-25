package com.scau.common.dto.human.org;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-24 12:40
 */
@Getter
@Setter
public class OrgReqDto implements Serializable {

    private static final long serialVersionUID = -5060212478494344058L;
    private Integer id;

    private String name;

    private Integer status;
}
