package com.eis_project.auth.api.request;

import lombok.Data;

/**
 * packageName   : com.eis_project.auth.api.request
 * fileName      : ReissuedToeknRequest
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성
 */

@Data
public class ReissuedToeknRequest {
    private String refreshToken;
}
