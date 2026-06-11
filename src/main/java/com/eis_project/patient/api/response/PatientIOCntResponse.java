package com.eis_project.patient.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.patient.api.request
 * fileName      : PatientIOCntResponse
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 5. 27.        어 진             최초생성
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientIOCntResponse {
    @Schema(description = "외래환자수", example = "1000")
    private Integer opdCnt;

    @Schema(description = "입원 환자수", example = "200")
    private Integer admCnt;
}
