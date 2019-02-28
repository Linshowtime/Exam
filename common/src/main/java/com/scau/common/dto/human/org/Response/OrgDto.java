package com.scau.common.dto.human.org.Response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-24 12:41
 */
@Getter
@Setter
public class OrgDto implements Serializable {
    private static final long serialVersionUID = 6849215590812306582L;
    private String name;

    private Integer status;

    private Integer id;
}
