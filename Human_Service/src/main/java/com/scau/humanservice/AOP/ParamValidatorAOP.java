/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.humanservice.AOP;

import com.scau.common.exception.bussiness.InvalidParameterException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.validator.HibernateValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Set;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/14 23:26
 */
@Component
@Aspect
public class ParamValidatorAOP {
    private static Logger logger = LoggerFactory.getLogger(ParamValidatorAOP.class);

    private final ExecutableValidator validator = getValidator();

    @Pointcut("execution(* com.scau.humanservice.serviceimpl..*(..))")
    public void checkParamAop() {

    }
    private static ExecutableValidator getValidator() {
        Locale.setDefault(Locale.CHINA);
        return Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory().getValidator().forExecutables();
    }
    @Before("checkParamAop()")
    public void before(JoinPoint point) throws SecurityException {

        //获得切入目标对象
        Object target = point.getThis();
        // 获得切入方法参数
        Object[] args = point.getArgs();
        // 获得切入的方法
        Method method = ((MethodSignature) point.getSignature()).getMethod();

        // 执行校验，获得校验结果
        Set<ConstraintViolation<Object>> validResult = validator.validateParameters(target, method, args);

        StringBuilder sb = new StringBuilder();
        if (!validResult.isEmpty()) {
            sb.append(method);
            for (ConstraintViolation<Object> violation : validResult) {
                String pathValue = violation.getPropertyPath().toString();
                String param = pathValue.substring(pathValue.lastIndexOf(".") + 1);
                String msg = param + violation.getMessage() + ";";
                sb.append(msg);
            }
            logger.info("参数错误:{}", sb.toString());
            throw new InvalidParameterException(sb.toString());
        }
    }
}

