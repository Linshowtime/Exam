/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.common.dto.human;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/14 22:23
 */
@Setter
@Getter
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -5017176741270172086L;

    private String username;

    @NotBlank(message = "registerNo不能为空")
    private String registerNo;

    @NotBlank(message = "password不能为空")
    private String password;

    private Integer gender;

    @NotBlank(message = "phone不能为空")
    private String phone;

    private String role;

    private Integer status;

}
