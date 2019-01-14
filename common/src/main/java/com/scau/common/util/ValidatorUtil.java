/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.common.util;

import com.scau.common.exception.bussiness.InvalidParameterException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/14 23:11
 */
public class ValidatorUtil {
    private ValidatorUtil() {
        super();
    }

    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 校验DTO中注解参数是否合法
     * <p>DTO必须继承BaseReqDTO基类</p>
     * @param baseReqDTO
     */
    public static void valid(BaseReqDTO baseReqDTO) {

        Set<ConstraintViolation<BaseReqDTO>> constraintViolations = validator.validate(baseReqDTO);

        if (constraintViolations.size() > 0) {
            // 校验到有异常的参数直接抛出
            Iterator<ConstraintViolation<BaseReqDTO>> iterator = constraintViolations.iterator();
            ConstraintViolation<BaseReqDTO> constraintViolation = iterator.next();
            throw new InvalidParameterException(constraintViolation.getPropertyPath()
                    + ": " + constraintViolation.getMessage());
        }
    }
}
