/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.examapi.exception;

/**
 * 应用层错误枚举类
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/22 22:09
 */
public enum AppErrorCodeEnum {
    UNKNOWN("未知错误",20001), MESSAGE_ERROE("手机短信服务出错，请重试",20002);
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
    public String getDetailMessage(){
        StringBuffer s = new StringBuffer();
        s.append("[错误").append(this.code).append(":").append(this.msg).append("]");
        return s.toString();
    }
}
