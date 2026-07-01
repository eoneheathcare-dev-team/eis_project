package com.eis_project.auth.application.facade;

import com.eis_project.auth.api.dto.TokenInfoDTO;
import com.eis_project.auth.api.request.LoginRequest;
import com.eis_project.auth.api.request.LogoutRequest;
import com.eis_project.auth.api.response.LoginResponse;
import com.eis_project.auth.application.service.AuthService;
import com.eis_project.common.CommonResult;
import com.eis_project.exception.CustomJwtException;
import com.eis_project.security.jwt.Jwt;
import com.eis_project.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * packageName   : com.eis_project.auth.application.facade
 * fileName      : AuthFacade
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthFacade {
    private final AuthService authService;
    private final JwtProvider jwtProvider;

    /**
     * description   :
     * ====================================================
     * DATE             AUTHOR              NOTE
     * ----------------------------------------------------
     * 26. 6. 23.       어 진              최초생성
     */
    @Transactional
    public LoginResponse login(LoginRequest loginRequest){
        //회원정보를 조회
        LoginResponse loginResponse = authService.getEmployeeInfo(loginRequest);

        //회원정보가 없으면 리턴
        if (loginResponse == null || loginResponse.getEmplNo() == null) {
            return null;
        }

        Jwt jwt = jwtProvider.generateToken(loginRequest.getEmplNo());
        authService.saveRefreshToken(loginRequest.getEmplNo(), jwt.getRefreshToken());
        loginResponse.setJwt(jwt);
        return loginResponse;
    }

    /**
     * description   :
     * ====================================================
     * DATE             AUTHOR              NOTE
     * ----------------------------------------------------
     * 26. 6. 23.       어 진              최초생성
     */
    @Transactional(noRollbackFor = CustomJwtException.class)
    public Jwt reissuedToken(String refreshToken) {
        TokenInfoDTO dto = authService.getEmplNoByRefreshToken(refreshToken);
        if(dto == null) {
            throw new CustomJwtException(CommonResult.Code.INVALID_JWT);
        } else if (dto.getEndDate().isBefore(LocalDateTime.now())) {
            authService.deleteRefreshToken(dto.getEmplNo());
            throw new CustomJwtException(CommonResult.Code.EXPIRED_JWT);
        } else {
            Jwt jwt = jwtProvider.generateToken(dto.getEmplNo());
            authService.updateRefreshToken(dto.getEmplNo(), jwt.getRefreshToken());
            return jwt;
        }
    }

    /**
     * description   :
     * ====================================================
     * DATE             AUTHOR              NOTE
     * ----------------------------------------------------
     * 26. 6. 23.       어 진              최초생성
     */

    @Transactional
    public void logout(LogoutRequest logoutRequest){
        authService.deleteRefreshToken(logoutRequest.getEmplNo());
    }
}
