/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.humanservice.AOP;

import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.scau.common.exception.ExceptionCode;
import com.scau.common.exception.bussiness.InvalidParameterException;
import com.scau.common.util.ValidatorUtil;
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
 * @date 2019/1/14 23:26
 */
@Component
@Aspect
public class ParamValidatorAOP {
    private static Logger logger = LoggerFactory.getLogger(ParamValidatorAOP.class);

    @Pointcut("execution(* com.scau.humanservice.serviceimpl..*(..))")
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
                throw new InvalidParameterException("传入参数为空!",ExceptionCode.INVAILD_PARAMETER.getCode());
            }
            ValidatorUtil.validate(param);
        });
    }
}

