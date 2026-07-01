package com.eis_project.auth.api.response;

import com.eis_project.security.jwt.Jwt;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * packageName   : com.eis_project.auth.api.response
 * fileName      : LoginResponse
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "로그인 응답 DTO")
@Alias("loginResponse")
public class LoginResponse {
    @Schema(description = "사번", example = "2024001")
    private Integer emplNo;

    @Schema(description = "이름", example = "김간호")
    private String emplNm;

    @Schema(description = "이름(영문)", example = "Kim Gan-ho")
    private String emplEnm;

    @Schema(description = "부서구분", example = "NUR")
    private String deptGb;

    @Schema(description = "부서구분명", example = "간호부")
    private String deptGbNm;

    @Schema(description = "직책구분", example = "RN")
    private String dutyGb;

    @Schema(description = "직책명", example = "일반간호사")
    private String dutyNm;

    @Schema(description = "부서코드", example = "WD51")
    private String deptCd;

    @Schema(description = "부서명칭", example = "51병동")
    private String deptNm;

    @Schema(description = "토큰", example = "토큰 Object")
    private Jwt jwt;
}
