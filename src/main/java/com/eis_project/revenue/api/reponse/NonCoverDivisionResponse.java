package com.eis_project.revenue.api.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.revenue.api.reponse
 * fileName      : NonCoverResponse
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 5. 21.       USER             최초생성
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NonCoverDivisionResponse {
    private String dutyGb;
    private String dutyNm;
    private Integer cnt;
}
