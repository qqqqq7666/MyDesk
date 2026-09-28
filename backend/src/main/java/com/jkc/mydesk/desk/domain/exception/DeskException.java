package com.jkc.mydesk.desk.domain.exception;

import com.jkc.mydesk.global.domain.exception.BusinessException;
import com.jkc.mydesk.global.domain.exception.ErrorCode;
import lombok.Getter;

@Getter
public class DeskException extends BusinessException {

    public DeskException(ErrorCode errorCode) {
        super(errorCode);
    }

    public DeskException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
