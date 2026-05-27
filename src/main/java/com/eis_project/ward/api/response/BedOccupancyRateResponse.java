package com.eis_project.ward.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.ward.api.reponse
 * fileName      : BedOccupancyRateResponse
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 5. 27.       어 진              최초생성
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BedOccupancyRateResponse {
    @Schema(description = "병상 가동률", example = "46.9")
    private Float value;
}
