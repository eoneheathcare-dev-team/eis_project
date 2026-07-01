package com.eis_project.auth.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.auth.api.request
 * fileName      : LogoutRequest
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성
 * 26. 7. 1.        김주한              로그아웃 요청값 유효성 검증 추가
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "로그아웃 요청 DTO")
public class LogoutRequest {
    @Schema(description = "사번", example = "99186")
    @NotNull(message = "emplNo is required")
    private Integer emplNo;
}
