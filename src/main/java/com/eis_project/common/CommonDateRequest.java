package com.eis_project.common;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.common
 * fileName      : CommonRequest
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 28.       김주한             최초생성
 * 26. 7. 1.        김주한              날짜 요청값 유효성 검증 추가
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonDateRequest {
    @NotBlank(message = "startYmd is required")
    @Pattern(regexp = "\\d{8}", message = "startYmd must be yyyyMMdd")
    private String startYmd;

    @NotBlank(message = "endYmd is required")
    @Pattern(regexp = "\\d{8}", message = "endYmd must be yyyyMMdd")
    private String endYmd;
}
