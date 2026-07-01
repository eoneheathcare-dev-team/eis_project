package com.eis_project.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * packageName   : com.eis_project.security.jwt
 * fileName      : Jwt
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성
 */

@Builder
@Getter
@AllArgsConstructor
public class Jwt {
    private String grantType;
    private String accessToken;
    private String refreshToken;
}
