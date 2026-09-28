package com.jkc.mydesk.user.domain.exception;

import com.jkc.mydesk.global.domain.exception.BusinessException;
import com.jkc.mydesk.global.domain.exception.ErrorCode;

public class UserException extends BusinessException {
    public UserException(ErrorCode errorCode) {
        super(errorCode);
    }

    public UserException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
