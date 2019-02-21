package com.scau.common.exception.bussiness;

import com.scau.common.exception.BusinessException;
import com.scau.common.exception.ExceptionCode;

/**
 * 知识点相关异常类
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-20 11:34
 */
public class InvalidKnowledgeException extends BusinessException {
    public InvalidKnowledgeException() {
        super();
    }

    public InvalidKnowledgeException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }

    public InvalidKnowledgeException(String message, int code) {
        super(message, code);
    }
}
