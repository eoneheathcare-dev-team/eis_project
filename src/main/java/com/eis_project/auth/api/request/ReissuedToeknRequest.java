package com.eis_project.auth.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * packageName   : com.eis_project.auth.api.request
 * fileName      : ReissuedToeknRequest
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성
 * 26. 7. 1.        김주한              토큰 재발급 요청값 유효성 검증 추가
 */

@Data
public class ReissuedToeknRequest {
    @NotBlank(message = "refreshToken is required")
    private String refreshToken;
}
