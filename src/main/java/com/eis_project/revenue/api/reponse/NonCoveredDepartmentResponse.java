package com.eis_project.revenue.api.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * packageName   : com.eis_project.revenue.api.reponse
 * fileName      : NonCoveredDepartmentResponse
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 1.       김주한             최초생성
*/


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NonCoveredDepartmentResponse {
    private String deptCd;
    private String deptNm;
    private BigDecimal amt;
}
