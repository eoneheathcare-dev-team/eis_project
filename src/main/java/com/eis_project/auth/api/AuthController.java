package com.eis_project.auth.api;

import com.eis_project.auth.api.request.LoginRequest;
import com.eis_project.auth.api.request.LogoutRequest;
import com.eis_project.auth.api.request.ReissuedToeknRequest;
import com.eis_project.auth.api.response.LoginResponse;
import com.eis_project.auth.application.facade.AuthFacade;
import com.eis_project.common.CommonResult;
import com.eis_project.security.jwt.Jwt;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName   : com.eis_project.auth.api
 * fileName      : AuthController
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성
 * 26. 7. 1.        김주한              요청값 유효성 검증 적용
 */

@Tag(name= "Auth Controller", description = "인증 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthFacade authFacade;

    @Operation(summary = "로그인", description = "직원 번호와 비밀번호로 회원 정보 가져오기 (비밀번호 공란 시 회원정보만 GET)")
    @PostMapping("/login")
    public CommonResult<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return CommonResult.success(authFacade.login(loginRequest));
    }

    @Operation(summary = "로그아웃", description = "로그아웃")
    @PostMapping("/logout")
    public CommonResult logout(@Valid @RequestBody LogoutRequest logoutRequest){
        authFacade.logout(logoutRequest);
        return CommonResult.success();
    }

    @Operation(summary = "refreshToken 으로 accessToken 재발급", description = "직원 번호와 비밀번호로 회원 정보 가져오기 (비밀번호 공란 시 회원정보만 GET)")
    @PostMapping("/reissued-token")
    public CommonResult<Jwt> reissuedToken(@Valid @RequestBody ReissuedToeknRequest reissuedToeknRequest) {
        return CommonResult.success(authFacade.reissuedToken(reissuedToeknRequest.getRefreshToken()));
    }
}
