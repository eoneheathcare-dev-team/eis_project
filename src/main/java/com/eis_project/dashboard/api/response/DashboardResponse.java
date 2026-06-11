package com.eis_project.dashboard.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.dashboard.api.response
 * fileName      : DashboardResponse
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 28.       USER             최초생성
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    private Integer opdCnt;

    private Integer admCnt;

    private Long totAmt;

    private Long opdAmt;

    private Long admAmt;

    private Double bedRate;

    private Integer anLocalCnt;

    private Integer anGeneralCnt;

    private Integer anRegionalCnt;
}
