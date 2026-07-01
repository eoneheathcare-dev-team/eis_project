package com.eis_project.security.jwt;

import com.eis_project.common.CommonResult;
import com.eis_project.exception.CustomJwtException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * packageName   : com.eis_project.security.jwt
 * fileName      : JwtAuthenticationFilter
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성
 */

@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {     // OncePerRequestFilter -> 요청마다 한번만 실행
    private final JwtProvider jwtProvider;
    private final ObjectMapper objectMapper = new ObjectMapper(); // 표준 패키지 사용

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request){
        String path = request.getServletPath();         // 요청이 어떤 서블릿 경로로 들어왔는지 반환

        return path.startsWith("/swagger-ui") ||        // 해당 문자열로 시작되면 true -> true 일 경우 filter 실행 되지 않고 건너뛰어짐
                path.startsWith("/v3/api-docs") ||
                path.startsWith("/api-docs") ||
                path.startsWith("/favicon.ico");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        try {
            String token = jwtProvider.resolveToken(request);                               // 요청 Authorization 에서 JWT 토큰 꺼내서 token에 담음
            if (token != null && jwtProvider.validateToken(token)){                         // 토큰이 존재하고, 유효한지 확인
                Authentication authentication = jwtProvider.getAuthentication(token);       // 토큰 안에 사용자 정보 꺼내서 객체 생성
                SecurityContextHolder.getContext().setAuthentication(authentication);       // 해당 요청은 인증된 사용자다 라는 처리
            }
            filterChain.doFilter(request, response);                                        // 다음 필터 요청
        } catch (CustomJwtException e) {                                                    // RuntimeException 일 경우 오류내용 반환
            sendErrorResponse(response, e);
        } catch (Exception e) {                                                             // 그 외 에러들
            log.error("알 수 없는 필터 에러 : ", e);
            filterChain.doFilter(request, response);
        }
    }

    private void sendErrorResponse(HttpServletResponse response, CustomJwtException ex) throws IOException {
        log.error("JWT 에러 발생: {}", ex.getCode().getMessage());      // 예외코드 정의된 내용 가져와 출력

        CommonResult<Object> responseResult = CommonResult.of(         // 에러 응답 표준화
                ex.getCode().getCode(),
                ex.getCode().getMessage(),
                ex.getData()
        );

        response.setStatus(ex.getCode().getHttpStatus().value());       // HTTP 응답 상태 코드 설정
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(responseResult));    // response 객체를 objectMapper로 JSON 변환하여 응답 본문에 작성
    }
}
