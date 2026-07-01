package com.eis_project.auth.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * packageName   : com.eis_project.auth.api.request
 * fileName      : LoginRequest
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성
 * 26. 7. 1.        김주한              로그인 요청값 유효성 검증 추가
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "로그인 요청 DTO")
@Alias("loginRequest")
public class LoginRequest {
    @Schema(description = "사번", example = "00000")
    @NotNull(message = "emplNo is required")
    private Integer emplNo;
    @Schema(description = "패스워드", example = "1234")
    @NotBlank(message = "password is required")
    private String password;
}
