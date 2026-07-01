package com.eis_project.exception;

import com.eis_project.common.CommonResult;

public class CustomServiceException extends RuntimeException {
    private final CommonResult.Code code;
    private final Object data;

    public CustomServiceException(CommonResult.Code code) {
        super(code.getMessage());
        this.code = code;
        this.data = null;
    }

    public CustomServiceException(CommonResult.Code code, Object data) {
        super(code.getMessage());
        this.code = code;
        this.data = data;
    }

}
