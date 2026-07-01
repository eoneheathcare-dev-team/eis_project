package com.eis_project.auth.repository;

import com.eis_project.auth.api.dto.TokenInfoDTO;
import com.eis_project.auth.api.request.LoginRequest;
import com.eis_project.auth.api.response.LoginResponse;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * packageName   : com.eis_project.auth.repository
 * fileName      : AuthMapper
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성 / PUSH는 하지 않기 때문에 FCM 토큰은 미작업
 */

public interface AuthMapper {
    LoginResponse getEmployeeInfo(LoginRequest loginRequest);

    void saveRefreshToken(
            @Param("emplNo") Integer emplNo,
            @Param("refreshToken")String refreshToken,
            @Param("refreshExpiration") Date refreshExpiration
    );

    TokenInfoDTO getEmplNoByRefreshToken(@Param("refreshToken") String refreshToken);

    void updateRefreshToken(
            @Param("emplNo") Integer emplNo,
            @Param("refreshToken") String refreshToken,
            @Param("refreshExpiration") Date refreshExpiration
    );

    void deleteRefreshToken(@Param("emplNo") Integer emplNo);
}
