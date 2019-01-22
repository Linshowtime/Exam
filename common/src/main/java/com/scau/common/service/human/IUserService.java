/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.common.service.human;

import com.scau.common.dto.human.UserDTO;
import org.springframework.validation.annotation.Validated;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/14 22:09
 */
public interface IUserService {
     void register( UserDTO userDTO);
}
