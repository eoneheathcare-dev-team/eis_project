package com.eis_project.dashboard.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.dashboard.api.request
 * fileName      : DashboardRequest
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
public class DashboardRequest {
    private String startYmd;
    private String endYmd;
    private Integer entEmplNo;
    private String entIp;
}
