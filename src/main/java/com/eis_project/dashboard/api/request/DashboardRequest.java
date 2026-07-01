package com.eis_project.dashboard.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.dashboard.api.request
 * fileName      : DashboardRequest
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 28.       김주한             최초생성
 * 26. 7. 1.        김주한              조회일자 요청값 유효성 검증 추가
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashboardRequest {
    @NotBlank(message = "searchYmd is required")
    @Pattern(regexp = "\\d{8}", message = "searchYmd must be yyyyMMdd")
    private String searchYmd;
}
