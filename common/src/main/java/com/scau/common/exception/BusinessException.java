/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.common.exception;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/14 21:46
 */
public class BusinessException extends RuntimeException {

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(ExceptionCode exceptionCode) {
        super(exceptionCode.getDetailMessage());
    }
}