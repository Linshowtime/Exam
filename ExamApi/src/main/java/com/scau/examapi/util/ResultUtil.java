/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.examapi.util;

import com.scau.examapi.net.Result;
/**
 * 返回结果工具类
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/24 23:41
 */
public class ResultUtil {
	// 当正确时返回的值
	public static Result success(Object data) {
		Result result = new Result();
		result.setCode(0);
		result.setMsg("OK");
		result.setData(data);
		return result;
	}

	public static Result success() {
		return success(null);
	}
	// 当错误时返回的值
	public static Result error(int code, String msg) {
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
}