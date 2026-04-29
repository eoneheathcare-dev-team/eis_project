package com.eis_project.patient.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.patient.api.response
 * fileName      : PatientOccupancyRateResponse
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
@Schema(description = "환자 수 통계 응답 객체")
public class PatientOccupancyRateResponse {
    @Schema(description = "전체 환자수", example = "500")
    private Integer allCnt;

    @Schema(description = "외래 환자수", example = "350")
    private Integer opdCnt;

    @Schema(description = "신규(신환) 환자수", example = "50")
    private Integer newCnt;

    @Schema(description = "입원 환자수", example = "100")
    private Integer admCnt;
}
