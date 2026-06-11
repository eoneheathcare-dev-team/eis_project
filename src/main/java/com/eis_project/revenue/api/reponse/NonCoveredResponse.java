package com.eis_project.revenue.api.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.revenue.api.reponse
 * fileName      : NonCoveredResponse
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
public class NonCoveredResponse {
    private String dutyGb;
    private String dutyNm;
    private String ordCd;
    private String ordNm;
    private Integer cnt;
}
