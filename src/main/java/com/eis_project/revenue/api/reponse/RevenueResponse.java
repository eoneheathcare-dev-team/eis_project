package com.eis_project.revenue.api.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.revenue.api.reponse
 * fileName      : RevenueRespose
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 28.       김주한             최초생성
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RevenueResponse {
    private String deptCd;
    private String deptNm;
    private Integer ordEmplNo;
    private String ordEmplNm;
    private Long opdAmt;
    private Long admAmt;
    private Integer totAmt;
}
