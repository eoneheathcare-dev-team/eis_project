package com.eis_project.common;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.common
 * fileName      : CommonDeptRequest
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 28.       김주한             최초생성
 * 26. 7. 1.        김주한              진료과 요청값 유효성 검증 추가
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonDeptRequest extends CommonDateRequest {
    @NotBlank(message = "deptCd is required")
    private String deptCd;
}
