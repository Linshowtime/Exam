/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.examapi.exception;

import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;
import com.scau.common.exception.BusinessException;
import com.scau.examapi.net.Result;
import com.scau.examapi.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 异常统一处理
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/22 21:45
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result jsonHandler(HttpServletRequest request, Exception e) {
        String message = e.getMessage();
        if (StringUtils.isEmpty(message)) {
            message = AppErrorCodeEnum.UNKNOWN.getMsg();
        }
        log(e, request);
        return ResultUtil.error(AppErrorCodeEnum.UNKNOWN.getCode(),message);
    }
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Result BusinessException(HttpServletRequest request, BusinessException e) {
        log(e,request);
        return ResultUtil.error(e.getCode(),e.getMsg());
    }
    private void log(Exception ex, HttpServletRequest request) {
        logger.error("request url：" + request.getRequestURL());
        logger.error("request os：" + request.getHeader("Operating-System"));
        Enumeration<String> enumeration = request.getParameterNames();
        logger.error("request param");
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            logger.error(name + ":" + request.getParameter(name));
        }
        logger.error("exception info", ex);
    }

}