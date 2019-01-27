/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.common.exception.bussiness;

import com.scau.common.exception.BusinessException;
import com.scau.common.exception.ExceptionCode;

/**
 * 用户相关异常
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/14 22:07
 */
public class InvalidUserException extends BusinessException {
    public InvalidUserException() {
        super();
    }

    public InvalidUserException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }

    public InvalidUserException(String message,int code) {
        super(message,code);
    }
}
