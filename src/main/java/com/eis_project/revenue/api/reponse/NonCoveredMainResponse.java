package com.eis_project.revenue.api.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * packageName   : com.eis_project.revenue.api.reponse
 * fileName      : NonCoveredMain
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
public class NonCoveredMainResponse {
    private Integer hangCnt;
    private Integer cnt;
    private BigDecimal nonAmt;
    private BigDecimal payAmt;
    private BigDecimal nonRate;
    private BigDecimal payRate;
}
