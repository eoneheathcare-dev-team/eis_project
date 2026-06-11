package com.eis_project.surgery.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.surgery.api.response
 * fileName      : SurgeryResponse
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
public class SurgeryResponse {
    private String deptCd;
    private String deptNm;
    private Integer doctEmplNo;
    private String doctEmplNm;
    private Integer cnt;
    private Integer totAmt;
}
