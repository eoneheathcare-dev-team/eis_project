package com.eis_project.auth.application.service;

import com.eis_project.auth.api.dto.TokenInfoDTO;
import com.eis_project.auth.api.request.LoginRequest;
import com.eis_project.auth.api.response.LoginResponse;
import com.eis_project.auth.repository.AuthMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * packageName   : com.eis_project.auth.application.service
 * fileName      : AuthService
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {
    private final AuthMapper authMapper;

    @Value("${jwt.refresh-expiration}")
    private long refreshExpireMs;

    public LoginResponse getEmployeeInfo(LoginRequest loginRequest) {
        return authMapper.getEmployeeInfo(loginRequest);
    }

    public void saveRefreshToken(Integer emplNo, String refreshToken) {
        Date refreshExpiration = new Date(System.currentTimeMillis() + refreshExpireMs);
        authMapper.saveRefreshToken(emplNo, refreshToken, refreshExpiration);
    }

    public TokenInfoDTO getEmplNoByRefreshToken(String refreshToken) {
        return authMapper.getEmplNoByRefreshToken(refreshToken);
    }

    public void updateRefreshToken(Integer emplNo, String refreshToken) {
        Date refreshExpiration = new Date(System.currentTimeMillis() + refreshExpireMs);
        authMapper.updateRefreshToken(emplNo, refreshToken, refreshExpiration);
    }

    public void deleteRefreshToken(Integer emplNo) {
        authMapper.deleteRefreshToken(emplNo);
    }
}
