package com.eis_project.exception;

import com.eis_project.common.CommonResult;
import lombok.Getter;

/**
 * packageName   : com.eis_project.exception
 * fileName      : CustomJwtException
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성
 */

@Getter
public class CustomJwtException extends RuntimeException {
    private final CommonResult.Code code;
    private final Object data;

    public CustomJwtException(CommonResult.Code code) {
        super(code.getMessage());
        this.code = code;
        this.data = null;
    }
}
