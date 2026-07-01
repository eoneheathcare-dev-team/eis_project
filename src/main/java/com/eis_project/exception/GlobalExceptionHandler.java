package com.eis_project.exception;

import com.eis_project.common.CommonResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomJwtException.class)
    public ResponseEntity<CommonResult<Void>> handleCustomJwtException(CustomJwtException e){

        CommonResult.Code errorCode = e.getCode();

        CommonResult<Void> responseBody = CommonResult.failure(errorCode);

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(responseBody);
    }
}
