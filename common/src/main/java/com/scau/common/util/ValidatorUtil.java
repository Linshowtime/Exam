/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.common.util;

import com.scau.common.dto.BaseReqDTO;
import com.scau.common.exception.ExceptionCode;
import com.scau.common.exception.bussiness.InvalidParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/14 23:11
 */
public class ValidatorUtil {
    private static Logger logger = LoggerFactory.getLogger(ValidatorUtil.class);
        private ValidatorUtil() {
        }
        private static Validator validator;

        public static <T> void validate(T obj) {
            Set<ConstraintViolation<T>> constraintViolations = getValidator().validate(obj);
            if (CollectionUtils.isEmpty(constraintViolations)) {
                return;
            }
            StringBuffer paramMsg = new StringBuffer();
            constraintViolations.forEach(violation -> paramMsg.append(violation.getMessage()).append(";"));
            logger.info(paramMsg.toString());
            throw new InvalidParameterException(paramMsg.toString(),ExceptionCode.INVAILD_PARAMETER.getCode());
        }

        private static Validator getValidator() {
            if (Objects.isNull(validator)) {
                ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
                validator = validatorFactory.getValidator();
            }
            return validator;
        }

    }

