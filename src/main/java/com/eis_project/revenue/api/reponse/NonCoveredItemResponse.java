package com.eis_project.revenue.api.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * packageName   : com.eis_project.revenue.api.reponse
 * fileName      : NonCoveredItemResponse
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
public class NonCoveredItemResponse {
    private String medfeeClassCd;
    private String medfeeClassNm;
    private Integer cnt;
    private BigDecimal amt;
    private BigDecimal rate;
}
