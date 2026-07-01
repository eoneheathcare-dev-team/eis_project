package com.eis_project.exception;

import com.eis_project.common.CommonResult;
import jakarta.validation.ConstraintViolationException;
import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * packageName   : com.eis_project.exception
 * fileName      : GlobalExceptionHandler
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 7. 1.        김주한              요청값 검증 및 프로시저 예외 처리 추가
*/

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonResult<List<Map<String, String>>>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e
    ) {
        return validationFailureResponse(toValidationErrors(e.getBindingResult()));
    }

    @ExceptionHandler(org.springframework.validation.BindException.class)
    public ResponseEntity<CommonResult<List<Map<String, String>>>> handleBindException(
            org.springframework.validation.BindException e
    ) {
        return validationFailureResponse(toValidationErrors(e.getBindingResult()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<CommonResult<List<Map<String, String>>>> handleConstraintViolationException(
            ConstraintViolationException e
    ) {
        List<Map<String, String>> errors = e.getConstraintViolations()
                .stream()
                .map(violation -> Map.of(
                        "field", violation.getPropertyPath().toString(),
                        "message", violation.getMessage()
                ))
                .toList();

        return validationFailureResponse(errors);
    }

    @ExceptionHandler({
            MyBatisSystemException.class,
            PersistenceException.class,
            DataAccessException.class
    })
    public ResponseEntity<CommonResult<Map<String, Object>>> handleProcedureException(Exception e) {
        SQLException sqlException = findCause(e, SQLException.class);
        return procedureFailureResponse(e, sqlException);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResult<?>> handleException(Exception e) {
        SQLException sqlException = findCause(e, SQLException.class);

        if (sqlException != null) {
            return ResponseEntity
                    .status(resolveProcedureErrorCode(sqlException).getHttpStatus())
                    .body(procedureFailureResponse(e, sqlException).getBody());
        }

        CommonResult.Code errorCode = CommonResult.Code.INTERNAL_SERVER_ERROR;
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(CommonResult.failure(errorCode, Map.of("cause", findRootCause(e).getMessage())));
    }

    private List<Map<String, String>> toValidationErrors(BindingResult bindingResult) {
        return bindingResult.getAllErrors()
                .stream()
                .map(this::toValidationError)
                .toList();
    }

    private Map<String, String> toValidationError(ObjectError error) {
        String field = error instanceof FieldError fieldError
                ? fieldError.getField()
                : error.getObjectName();

        return Map.of(
                "field", field,
                "message", String.valueOf(error.getDefaultMessage())
        );
    }

    private ResponseEntity<CommonResult<List<Map<String, String>>>> validationFailureResponse(
            List<Map<String, String>> errors
    ) {
        CommonResult.Code errorCode = CommonResult.Code.VALIDATION_FAILED;

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(CommonResult.failure(errorCode, errors));
    }

    private ResponseEntity<CommonResult<Map<String, Object>>> procedureFailureResponse(
            Exception e,
            SQLException sqlException
    ) {
        CommonResult.Code errorCode = resolveProcedureErrorCode(sqlException);
        Map<String, Object> data = buildProcedureErrorData(e, sqlException);

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(CommonResult.failure(errorCode, data));
    }

    private CommonResult.Code resolveProcedureErrorCode(SQLException e) {
        if (e == null) {
            return CommonResult.Code.INTERNAL_SERVER_ERROR;
        }

        int errorCode = e.getErrorCode();
        String message = String.valueOf(e.getMessage());

        if (errorCode == 241 || message.contains("날짜") || message.contains("date") || message.contains("time")) {
            return CommonResult.Code.INVALID_DATE;
        }

        if (errorCode == 8114 || message.contains("데이터 형식") || message.contains("convert")) {
            return CommonResult.Code.VALIDATION_FAILED;
        }

        return CommonResult.Code.INTERNAL_SERVER_ERROR;
    }

    private Map<String, Object> buildProcedureErrorData(Exception e, SQLException sqlException) {
        String message = String.valueOf(e.getMessage());
        Map<String, Object> data = new LinkedHashMap<>();

        data.put("mapper", extractFirst(message, "### The error may involve ([^\\r\\n]+)"));
        data.put("procedure", extractFirst(message, "CALL\\s+([^\\s(]+)"));

        if (sqlException != null) {
            data.put("sqlState", sqlException.getSQLState());
            data.put("sqlErrorCode", sqlException.getErrorCode());
            data.put("cause", sqlException.getMessage());
        } else {
            data.put("cause", findRootCause(e).getMessage());
        }

        return data;
    }

    private String extractFirst(String text, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(text);
        return matcher.find() ? matcher.group(1).trim() : null;
    }

    private Throwable findRootCause(Throwable throwable) {
        Throwable cause = throwable;

        while (cause.getCause() != null && cause.getCause() != cause) {
            cause = cause.getCause();
        }

        return cause;
    }

    private <T extends Throwable> T findCause(Throwable throwable, Class<T> type) {
        Throwable cause = throwable;

        while (cause != null) {
            if (type.isInstance(cause)) {
                return type.cast(cause);
            }

            cause = cause.getCause();
        }

        return null;
    }
}
