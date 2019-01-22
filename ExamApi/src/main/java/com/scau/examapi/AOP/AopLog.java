/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.examapi.AOP;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import eu.bitwalker.useragentutils.UserAgent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/22 22:42
 */
@Aspect
@Component
public class AopLog {
    private static Logger logger = LoggerFactory.getLogger(AopLog.class);
    private static final String START_TIME = "start-request";

    @Pointcut("execution(* com.scau.examapi.controller..*(..))")
    public void log() {
    }

    @Around("log()")
    public Object arroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("===============================请求开始=============================");
        logger.info("[请求 URL]:{}", request.getRequestURL());
        logger.info("[请求 IP]:{}", request.getRemoteAddr());
        logger.info("[请求类名]:{}，[请求方法名]：{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        logger.info("[请求参数]:{}，", argsToString(joinPoint.getArgs()));
        Long start = System.currentTimeMillis();
        request.setAttribute(START_TIME, start);
        Object result = joinPoint.proceed();

        logger.info("[返回值]:{}", JSONObject.toJSON(result));
        return result;
    }

    @AfterReturning("log()")
    public void afterReturning(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Long start = (Long) request.getAttribute(START_TIME);
        Long end = System.currentTimeMillis();
        logger.info("[请求耗时]:{}毫秒", end - start);        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        logger.info("[浏览器类型]:{}，[操作系]:{}，[原始User-Agent]:{}", userAgent.getBrowser().toString(), userAgent.getOperatingSystem().toString(), header);
        logger.info("==============================请求结束==============================");    }

    private String argsToString(Object[] object) {
        try {
            if (object != null && object.length >= 1) {
                if (!(object[0] instanceof HttpServletRequest)) {
                    return JSON.toJSONString(object[0]);                }
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        return "";
    }
}
