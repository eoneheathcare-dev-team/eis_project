package com.eis_project.patient.api.request;

import com.eis_project.common.CommonDateRequest;
import jakarta.validation.constraints.NotBlank;
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
 * 26. 7. 1.        김주한              입외구분 요청값 유효성 검증 추가
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientIORequest extends CommonDateRequest {
    @NotBlank(message = "ioGb is required")
    private String ioGb;
}
