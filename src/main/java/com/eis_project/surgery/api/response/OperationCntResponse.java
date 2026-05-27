package com.eis_project.surgery.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.surgery.api.response
 * fileName      : OperationCntResponse
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
public class OperationCntResponse {
    @Schema(description = "수술건수", example = "153")
    private Integer totCnt;
}
