/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.examapi.exception;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/22 22:09
 */
public enum AppErrorCodeEnum {
    UNKNOWN("未知错误",20001);
    private int code;
    private String msg;
    AppErrorCodeEnum(String msg,int code){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
