/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/14 21:46
 */
@Setter
@Getter
public class BusinessException extends RuntimeException {
    private String msg;
    private int code;
    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }
    public BusinessException(String message,int code) {
        super(message);
        this.msg = message;
        this.code = code;
    }

    public BusinessException(ExceptionCode exceptionCode) {
        super(exceptionCode.getDetailMessage());
        this.msg = exceptionCode.getMsg();
        this.code = exceptionCode.getCode();
    }
}