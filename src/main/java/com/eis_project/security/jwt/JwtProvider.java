package com.eis_project.security.jwt;

import com.eis_project.common.CommonResult;
import com.eis_project.exception.CustomJwtException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;

/**
 * packageName   : com.eis_project.security.jwt
 * fileName      : JwtProvider
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성
 */

@Slf4j
@Component
public class JwtProvider {
    private final Key key;
    private final long accessTokenExpiration;

    public JwtProvider(@Value("${jwt.access-secret}") String secretKey
            , @Value("${jwt.access-expiration}") long accessTokenExpiration) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);                // 해시 기반 인증코드 알고리즘
        this.accessTokenExpiration = accessTokenExpiration;     // 설정파일에서 읽어온 토큰 만료시간을 필드에 저장.
    }

    public String resolveToken(HttpServletRequest httpServletRequest){
        return Optional.ofNullable(httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION))     // 요청헤더 AUTHORIZATION 값 가져옴
                .filter(token -> token.startsWith("Bearer"))                              // Bearer로 시작하는지 확인
                .map(token -> token.substring(7, token.length()))                         // 실제 토큰값만 추출
                .orElse(null);                                                             // 위 과정에서 토큰을 못가져왔으면 null 반환
    }

    public Jwt generateToken(Integer emplNo){
        long now = new Date().getTime();
        return Jwt.builder()
                .grantType("bearer")
                .accessToken(generateAccessToken(emplNo.toString(), new Date(now + accessTokenExpiration)))
                .refreshToken(generateRefreshToken())
                .build();
    }

    public String generateAccessToken(String emplNo, Date expiration){
        return Jwts.builder()
                .setSubject(emplNo)         // 사용자 이름
                .setExpiration(expiration)  // 만료기한
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateRefreshToken() {
        return UUID.randomUUID().toString();
    }

    public Authentication getAuthentication(String accessToken) {
        Claims claims = parseClaims(accessToken);                                                   // 서명검증, 만료여부 확인
        Collection<? extends GrantedAuthority> authorities =
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));                 // 사용자에게 어떤 권한을 줄지 (ROLE_USER)
        UserDetails principal = new User(claims.getSubject(), "", authorities);             // 인증 주체를 생성
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);        // 인증 객체 반환
    }

    public boolean validateToken(String accessToken){
        try {
            // 토큰 파싱 시도
            Jwts.parserBuilder()                    // JWT 파서 객체 생성
                    .setSigningKey(key)             // 서명 검증에 사용할 key 지정
                    .build()
                    .parseClaimsJws(accessToken);   // 토큰 파싱하고 서명 검증
            return true;
        } catch (ExpiredJwtException e){
            // 만료시간이 지나서 유효하지 않음
            log.error("JWT 만료됨 : {}", e.getMessage());
            throw new CustomJwtException(CommonResult.Code.EXPIRED_JWT);

        } catch (MalformedJwtException e){
            // 토큰 구조가 잘못됨 (헤더/서명부분 깨짐 등)
            log.error("JWT 구조 이상: {}", e.getMessage());
            throw new CustomJwtException(CommonResult.Code.INVALID_JWT);

        } catch (SecurityException | io.jsonwebtoken.security.SignatureException e){
            // 토큰 서명 유효하지 않음 (위변조 가능성 높음)
            log.error("JWT 서명 불일치 : {}", e.getMessage());
            throw new CustomJwtException(CommonResult.Code.INVALID_JWT);

        } catch (UnsupportedJwtException e){
            // 지원되지 않는 형식
            log.error("지원되지 않는 JWT: {}", e.getMessage());
            throw new CustomJwtException(CommonResult.Code.INVALID_JWT);

        } catch (IllegalArgumentException e){
            // 빈 값(NULL, EMPTY) 인 경우
            log.error("JWT 클레임이 비어있음: {}", e.getMessage());
            throw new CustomJwtException(CommonResult.Code.INVALID_JWT);

        } catch (JwtException e){
            // 그 외 기타 JWT 에러
            log.error("JWT 인증 에러 (기타): {}", e.getMessage());
            throw new CustomJwtException(CommonResult.Code.INVALID_JWT);
        }
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder()                 // JWT 파서 생성
                    .setSigningKey(key)                 // 토큰 발급할 때 사용한 서명 키 지정
                    .build()
                    .parseClaimsJws(accessToken)        // Access Token을 실제로 파싱하면서 서명 검증
                    .getBody();                         // 토큰의 Payload(Claims)를 꺼냄 (사용자 ID, 만료 시간 등)
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }
}
