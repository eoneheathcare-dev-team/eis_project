package com.eis_project.revenue.api;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.common.CommonDeptRequest;
import com.eis_project.common.CommonMedfeeRequest;
import com.eis_project.common.CommonResult;
import com.eis_project.common.CommonSearchYmdRequest;
import com.eis_project.revenue.api.reponse.*;
import com.eis_project.revenue.application.facade.RevenueFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** 
 * packageName   : com.eis_project.revenue.api
 * fileName      : RevenueController
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 28.       김주한             최초생성
 * 26. 5. 27.       어 진              입원/외래 총 진료비 조회 추가
 * 26. 6. 01.       김주한             비급여 항목, 추이, 진료과별, 메인, 항목상세 API 추가
 * 26. 7. 01.        김주한              요청값 유효성 검증 적용
 * 26. 7. 02.        김주한             비급여 세부, 입원 / 외래 총 진료비 주석처리 (App 에서 미사용)
*/

@Tag(name = "Revenue", description = "수익 통계 API")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/revenue")
public class RevenueController {
    private final RevenueFacade revenueFacade;

    @Operation(summary = "수익 - 부서 조회", description = "")
    @GetMapping("/dept")
    public CommonResult<List<RevenueDeptResponse>> revenueDept(@Valid CommonDateRequest request) {
        return CommonResult.success(revenueFacade.revenueDept(request));
    }

    @Operation(summary = "수익 - 진료의 조회", description = "")
    @GetMapping("")
    public CommonResult<List<RevenueResponse>> revenue(@Valid CommonDeptRequest request) {
        return CommonResult.success(revenueFacade.revenue(request));
    }

    /*@Operation(summary = "비급여 세부", description = "")
    @GetMapping("/non-covered")
    public CommonResult<List<NonCoveredResponse>> nonCovered(@Valid CommonDateRequest request) {
        return CommonResult.success(revenueFacade.nonCovered(request));
    }*/

    @Operation(summary = "비급여 분류", description = "")
    @GetMapping("/non-covered/division")
    public CommonResult<List<NonCoverDivisionResponse>> nonCoveredDivision(@Valid CommonDateRequest request) {
        return CommonResult.success(revenueFacade.nonCoveredDivision(request));
    }

    /*@Operation(summary = "입원 외래 총 진료비 ", description = "")
    @GetMapping("/profit/clinic")
    public CommonResult<List<TotalClinicRevenueResponse>> totalClinicRevenue(@Valid CommonSearchYmdRequest request) {
        return CommonResult.success(revenueFacade.totalClinicRevenue(request.getSearchYmd()));
    }*/

    @Operation(summary = "비급여 항목", description = "")
    @GetMapping("/non-covered/item")
    public CommonResult<List<NonCoveredItemResponse>> nonCoveredItem(@Valid CommonDateRequest request) {
        return CommonResult.success(revenueFacade.nonCoveredItem(request));
    }

    @Operation(summary = "비급여 추이", description = "")
    @GetMapping("/non-covered/transition")
    public CommonResult<List<NonCoveredTransitionResponse>> nonCoveredTransition(@Valid CommonDateRequest request) {
        return CommonResult.success(revenueFacade.nonCoveredTransition(request));
    }

    @Operation(summary = "비급여 - 진료과별", description = "")
    @GetMapping("/non-covered/department")
    public CommonResult<List<NonCoveredDepartmentResponse>> nonCoveredDepartment(@Valid CommonDateRequest request) {
        return CommonResult.success(revenueFacade.nonCoveredDepartment(request));
    }

    @Operation(summary = "비급여 - 메인", description = "")
    @GetMapping("/non-covered/main")
    public CommonResult<List<NonCoveredMainResponse>> nonCoveredMain(@Valid CommonDateRequest request) {
        return CommonResult.success(revenueFacade.nonCoveredMain(request));
    }

    @Operation(summary = "비급여 - 상세", description = "")
    @GetMapping("/non-covered/detail")
    public CommonResult<List<NonCoveredDetailResponse>> nonCoveredDetail(@Valid CommonMedfeeRequest request) {
        return CommonResult.success(revenueFacade.nonCoveredDetail(request));
    }
}
