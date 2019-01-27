/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.examapi.exception;

/**
 * 应用层异常类
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/24 23:41
 */
public class AppRunTimeException extends RuntimeException {
    private String msg;
    private int code;
    public AppRunTimeException() {
        super();
    }

    public AppRunTimeException(String message) {
        super(message);
    }
    public AppRunTimeException(String message,int code) {
        super(message);
        this.msg = message;
        this.code = code;
    }
    public AppRunTimeException(AppErrorCodeEnum exceptionCode) {
        super(exceptionCode.getDetailMessage());
        this.msg = exceptionCode.getMsg();
        this.code = exceptionCode.getCode();
    }
}
