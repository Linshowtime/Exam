/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.subjectservice.AOP;

import com.scau.common.exception.ExceptionCode;
import com.scau.common.exception.bussiness.InvalidParameterException;
import com.scau.common.util.ValidatorUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * rpc服务间参数校验切面类
 *
 * @author showtime
 * @version V1.0
 * @date 2019/2/20 9:15
 */
@Component
@Aspect
public class ParamValidatorAOP {
    private static Logger logger = LoggerFactory.getLogger(ParamValidatorAOP.class);

    @Pointcut("execution(* com.scau.subjectservice.serviceimpl..*(..))")
    public void checkParamAop() {

    }

    @Before("checkParamAop()")
    public void before(JoinPoint point) throws SecurityException {
        Object[] args = point.getArgs();
        this.paramValidate(args);
    }

    private void paramValidate(Object[] params) {
        if (ArrayUtils.isEmpty(params)) {
            return;
        }
        Stream.of(params).forEach(param -> {
            if (Objects.isNull(param)) {
                logger.info("传入参数为空");
                throw new InvalidParameterException("传入参数为空!", ExceptionCode.INVAILD_PARAMETER.getCode());
            }
            ValidatorUtil.validate(param);
        });
    }
}

