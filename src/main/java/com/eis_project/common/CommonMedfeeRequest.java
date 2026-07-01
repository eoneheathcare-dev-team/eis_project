package com.eis_project.common;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.common
 * fileName      : CommonMedfeeRequest
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 1.       USER             최초생성
 * 26. 7. 1.        김주한              비급여 분류 요청값 유효성 검증 추가
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonMedfeeRequest extends CommonDateRequest {
    @NotBlank(message = "medfeeClassCd is required")
    private String medfeeClassCd;
}
