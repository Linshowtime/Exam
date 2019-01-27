/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.common.dto.human;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 更新用户信息传输实体
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/27 23:20
 */
@Setter
@Getter
public class UpdateUserDTO implements Serializable {
    private static final long serialVersionUID = -7119959128254469767L;
    private String username;
    private String password;
    private Integer gender;
    private String phone;
    @NotBlank(message = "registerNo不能为空")
    private String registerNo;
    private Integer status;
}
