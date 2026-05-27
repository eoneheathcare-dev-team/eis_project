package com.eis_project.revenue.api.reponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.revenue.api.reponse
 * fileName      : TotalClinicRevenueResponse
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 5. 27.       어 진              최초생성
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TotalClinicRevenueResponse {
    @Schema(description = "외래 총 진료비", example = "103513472")
    private String opdClinicAmt;

    @Schema(description = "입원 총 진료비", example = "51342153")
    private String admClinicAmt;
}
