package com.eis_project.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * packageName   : com.nurse_notice.common
 * fileName      : CommonResult
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 29.       김주한             최초생성
*/

@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
public class CommonResult<D> {
    private final String code;
    private final String message;
    private final D data; //오류시에 세부정보 매핑

    public static <D> CommonResult<D> success() {
        return of(Code.SUCCESS.code, Code.SUCCESS.message, null);
    }

    public static <D> CommonResult<D> success(D data) {
        return of(Code.SUCCESS.code, Code.SUCCESS.message, data);
    }

    public static <D> CommonResult<D> failure(Code errorCode, D data) {
        return of(errorCode.code, errorCode.message, data);
    }

    public static CommonResult<Void> failure(Code errorCode) {
        return of(errorCode.code, errorCode.message, null);
    }

    /**
     * description   : 코드 정리
     * code는 유니크하게 유지필요
     * HTTPS code와 구별하기 용이하도록 앞에 Prefix 적용 (S-성공 E-에러,실패)
     * S000	공통 Success 응답 (성공응답은 현재 세분화 x - 필요시 PL 에게 문의)
     * E000 공통 Error 응답
     * E0xx	System Error	예기치 못한 서버 오류 (서버 내부 문제 등)
     * E1xx	Authentication / Authorization	인증, 인가 오류 (JWT, 로그인 등)
     * E2xx	Validation	파라미터, DTO 유효성 검사 오류
     * E3xx	Resource	리소스 없음, 중복 등 (예: 중복 등록 등 / 사용자 관련은 E1xx 에서 처리)
     * E4xx	Business Logic	비즈니스 로직 위반 (예: 잔액 부족, 승인 실패 등)
     * E5xx	External API	외부 시스템/API 연동 실패
     * E9xx	Unknown / Misc	미분류 오류, 포괄적인 에러 등
     * ====================================================
     * DATE             AUTHOR              NOTE
     * ----------------------------------------------------
     * 25. 12. 24.      김주한             최초생성
     * ====================================================
     **/
    @Getter
    @AllArgsConstructor
    public enum Code {
        //공통성공
        SUCCESS("S000", HttpStatus.OK, "Success"),

        //예상치 못한 서버에러 (DATA 안에 printStackTrace 로 확인가능하게 ExceptionHandler 에서 처리함)
        INTERNAL_SERVER_ERROR("E000", HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),

        //Authentication / Authorization / JWT ERROR (로그인 등)
        INVALID_AUTH("E100", HttpStatus.FORBIDDEN, "forbidden"),
        INVALID_JWT("E101", HttpStatus.FORBIDDEN, "Invalid JWT Token"), //토큰은 정상적이지만 유저가 접근권한이 없을 때, 혹은 변조된 JWT일 경우
        EXPIRED_JWT("E102", HttpStatus.UNAUTHORIZED, "Expired JWT Token"), //(**해당 에러시만 프론트에서 refresh 토큰으로 access 토큰 재발급**)토큰이 없거나 Authorization 헤더 누락이거나 만료된 토큰을 보냈을 때
        INVALID_USERNAME_OR_PASSWORD("E103", HttpStatus.UNAUTHORIZED, "Invalid ID or password. Please try again."), //비밀번호 또는 사용자 불일치 // USERNAME 과 PASSWORD 를 별도로 관리하면 보안상 문제가 있어 함께처리 (아이디 존재 여부만 확인가능하면 안됨)
        MISSING_POC_AUTHORITY("E104", HttpStatus.FORBIDDEN, "POC authority information is missing in JWT"), //프론트 접속 POC별 권한정보가 토큰에 들어있지 않음
        ACCOUNT_DISABLED("E105", HttpStatus.FORBIDDEN, "Your access has been restricted by an administrator."), // 비활성화된 계정
        NO_MENU_PERMISSION("E106", HttpStatus.FORBIDDEN, "No menu access permission"),

        //유효성검사 (dto에 @Valid 선원되어 있는 경우로, 세부 내용이 data 배열로 들어가는 케이스 : 현재 해당 에러만 data의 데이터 형식 다름)
        VALIDATION_FAILED("E200", HttpStatus.BAD_REQUEST, "Validation failed"), //컨트롤러 body 의 dto내 유효성검사 실패

        //리소스 오류 (중복, 없음 등)
        RESOURCE_NOT_FOUND("E301", HttpStatus.NOT_FOUND, "Resource not found"),
        DUPLICATE_RESOURCE("E302", HttpStatus.CONFLICT, "Resource already exists"),
        RESOURCE_MISMATCH("E303", HttpStatus.UNPROCESSABLE_ENTITY, "Resource mismatch"),
        STATUS_NOT_MODIFIABLE("E304", HttpStatus.NOT_MODIFIED, "Status not modifiable"),


        //인증이후 비즈니스 로직에서 에러 정리
        PASSWORD_MISMATCH("E401", HttpStatus.BAD_REQUEST, "Current password does not match"),
        ORDER_LIMIT_EXCEEDED("E402", HttpStatus.BAD_REQUEST, "Requested amount exceeds available credit limit"),
        ISSUED_ITEM("E403", HttpStatus.BAD_REQUEST, "This item has been issued"),
        ORDER_QTY_EXCEEDED("E404", HttpStatus.BAD_REQUEST, "It's more than the order quantity"),
        ORDER_QTY_BELOW("E405", HttpStatus.BAD_REQUEST, "It's less than the order quantity"),
        MISSING_CHECK_ITEM("E406", HttpStatus.BAD_REQUEST, "There are missing check item"),
        INVALID_DATE("E407", HttpStatus.BAD_REQUEST, "Input date is invalid"),

        // 외부 API 연동 실패
        EXTERNAL_API_ERROR("E500", HttpStatus.BAD_GATEWAY, "External API error"),
        EXTERNAL_API_TIMEOUT("E501", HttpStatus.GATEWAY_TIMEOUT, "External API timeout"),
        EXTERNAL_API_BAD_REQUEST("E502", HttpStatus.BAD_REQUEST, "External API bad request"),
        EXTERNAL_API_UNAUTHORIZED("E503", HttpStatus.UNAUTHORIZED, "External API unauthorized"),
        EXTERNAL_API_FORBIDDEN("E504", HttpStatus.FORBIDDEN, "External API forbidden"),
        EXTERNAL_API_NOT_FOUND("E505", HttpStatus.NOT_FOUND, "External API resource not found");

        private final String code;
        private final HttpStatus httpStatus;
        private final String message;
    }
}