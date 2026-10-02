package com.jkc.mydesk.global.adapter.in.web;

import com.jkc.mydesk.global.adapter.in.web.dto.ErrorResponse;
import com.jkc.mydesk.global.domain.exception.BusinessException;
import com.jkc.mydesk.global.domain.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handle(BusinessException e) {
        ErrorCode errorCode = e.getErrorCode();
        log.error("Error: {}", errorCode.getMessage(), e);

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(new ErrorResponse(
                        e.getErrorCode(),
                        e.getMessage()
                ));
    }

    // @RequestBody(MethodArgumentNotValidException), @ModelAttribute 검증 실패 모두 처리
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> handle(BindException e) {
        ErrorCode errorCode = ErrorCode.INVALID_INPUT;
        String message = e.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(FieldError::getDefaultMessage)
                .orElse(errorCode.getMessage());
        log.error("Validation Error: {}", message);

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(new ErrorResponse(errorCode, message));
    }
}
