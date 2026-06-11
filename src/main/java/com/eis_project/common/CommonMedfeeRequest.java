package com.eis_project.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * packageName   : com.eis_project.common
 * fileName      : CommonMedfeeRequest
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 1.       USER             최초생성
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonMedfeeRequest extends CommonDateRequest {
    private String medfeeClassCd;
}
