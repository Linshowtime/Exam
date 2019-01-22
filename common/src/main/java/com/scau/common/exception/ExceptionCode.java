/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.common.exception;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/14 21:59
 */
public enum ExceptionCode {
    EXIST_REGISTER_NO_ERROR(10001,"该账号已存在"), EXIST_PHONE(10002,"该号码已注册"),INVAILD_PARAMETER(10003,"无效参数");
    private int code;//错误码
    private String msg;//描述信息
    ExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    public String getDetailMessage(){
        StringBuffer s = new StringBuffer();
        s.append("[错误").append(this.code).append(":").append(this.msg).append("]");
        return s.toString();
    }
}
