package com.eis_project.patient.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.patient.api.response
 * fileName      : PatientVistRouteResponse
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
public class PatientVisitRouteResponse {
    private Integer comeTypeGb;
    private String comeTypeNm;
    private Integer cnt;
}
