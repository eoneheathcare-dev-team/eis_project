package com.eis_project.security.constants;

/**
 * packageName   : com.eis_project.security.constants
 * fileName      : SecurityConstants
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성
 */

public class SecurityConstants {
    // 객체 생성 방지
    private SecurityConstants() { throw new IllegalStateException("Utility class"); }

    // Auth 관련
    public static final String[] AUTH_WHITELIST = {
            "/api/v1/auth/login",
            "/api/v1/auth/reissued-token",
            "/api/v1/auth/fcm-token",
            "/api/v1/signup"
    };

    // Swagger 관련
    public static final String[] SWAGGER_WHITELIST = {
            "/swagger",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/api-docs",
            "/api-docs/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/webjars/**"
    };
}
