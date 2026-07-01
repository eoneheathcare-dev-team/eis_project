package com.eis_project.security.config;

import com.eis_project.security.constants.SecurityConstants;
import com.eis_project.security.jwt.JwtAuthenticationFilter;
import com.eis_project.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * packageName   : com.eis_project.security.config
 * fileName      : SecurityConfig
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성
 */

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtProvider jwtProvider;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .cors(AbstractHttpConfigurer::disable)                                      // CORS 비활성화
                .csrf(CsrfConfigurer::disable)                                              // CSRF 비활성화 (CSRF는 브라우저 쿠키 기반 세션인데 JWT는 헤더에 토큰은 담아 보내므로 보통 끔)
                .formLogin(FormLoginConfigurer::disable)                                    // 기본 로그인 폼 비활성화 -> jwt 기반 로그인 API로 인증
                .sessionManagement(                                                         // 서버쪽에서 세션 상태를 저장하지 않음 -> 토큰 자체에 만료시간이 있기 때문
                        session ->
                                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth
                        -> auth
                        .requestMatchers("/api/v1/auth/logout").authenticated()     // logout은 권한 있어야 실행가능
                        .requestMatchers(SecurityConstants.AUTH_WHITELIST).permitAll()      // 권한 관련은 패스
                        .requestMatchers(SecurityConstants.SWAGGER_WHITELIST).permitAll()   // swagger 관련은 패스
                        .anyRequest().authenticated())                                      // 위에서 지정한 api 외 나머지는 전부 권한 필요
                .addFilterBefore(new JwtAuthenticationFilter(jwtProvider),                  // JwtAuthenticationFilter 를 UsernamePasswordAuthenticationFilter 앞에 추가
                        UsernamePasswordAuthenticationFilter.class)                         // 세션/폼 로그인 기반이 아니라 jwt 토큰 기반 인증이기 때문에 jwt를 앞에
                .build();
    }
}
