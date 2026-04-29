package com.eis_project.patient.api.request;

import com.eis_project.common.CommonDateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.patient.api.request
 * fileName      : PatientVistRouteRequest
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
public class PatientIORequest extends CommonDateRequest {
    private String ioGb;
}
