package com.eis_project.dashboard.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.dashboard.api.response
 * fileName      : DashboardPatientCountResponse
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 1.       김주한             최초생성
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashboardCountResponse {
    private Integer opdCnt;
    private Integer admCnt;
}
