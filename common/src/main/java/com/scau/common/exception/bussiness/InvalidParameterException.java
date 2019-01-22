/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.common.exception.bussiness;

import com.scau.common.exception.BusinessException;
import com.scau.common.exception.ExceptionCode;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/14 22:04
 */
public class InvalidParameterException extends BusinessException {
    public InvalidParameterException() {
        super();
    }

    public InvalidParameterException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }

    public InvalidParameterException(String message,int code) {
        super(message,code);
    }
}
