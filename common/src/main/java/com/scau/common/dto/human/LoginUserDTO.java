/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.common.dto.human;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户登录传输实体
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/14 22:23
 */
@Setter
@Getter
public class LoginUserDTO implements Serializable {
    private static final long serialVersionUID = -5017176741270172086L;
    private String username;
    @NotBlank(message = "registerNo不能为空")
    private String registerNo;
    @NotBlank(message = "password不能为空")
    private String password;
    private Integer gender;
    private String phone;
    @NotNull(message = "role不能为空")
    private Integer role;
}
