/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.examapi.net;
/**
 * 返回前端的结果类（与前端达成一致）
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/24 23:41
 */
public class Result {
	private int code;// 状态码
	private String msg;// 信息
	private Object data;// 数据
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
