package com.eis_project.revenue.api;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.common.CommonDeptRequest;
import com.eis_project.common.CommonResult;
import com.eis_project.revenue.api.reponse.NonCoverDivisionResponse;
import com.eis_project.revenue.api.reponse.NonCoveredResponse;
import com.eis_project.revenue.api.reponse.RevenueDeptResponse;
import com.eis_project.revenue.api.reponse.RevenueResponse;
import com.eis_project.revenue.application.facade.RevenueFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/** 
 * packageName   : com.eis_project.revenue.api
 * fileName      : RevenueController
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 28.       김주한             최초생성
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
    public CommonResult<List<RevenueDeptResponse>> revenueDept(CommonDateRequest request) {
        return CommonResult.success(revenueFacade.revenueDept(request));
    }

    @Operation(summary = "수익 - 진료의 조회", description = "")
    @GetMapping("")
    public CommonResult<List<RevenueResponse>> revenue(CommonDeptRequest request) {
        return CommonResult.success(revenueFacade.revenue(request));
    }

    @Operation(summary = "비급여 세부", description = "")
    @GetMapping("/non-covered")
    public CommonResult<List<NonCoveredResponse>> nonCovered(CommonDateRequest request) {
        return CommonResult.success(revenueFacade.nonCovered(request));
    }

    @Operation(summary = "비급여 분류", description = "")
    @GetMapping("/non-covered/division")
    public CommonResult<List<NonCoverDivisionResponse>> nonCoveredDivision(CommonDateRequest request) {
        return CommonResult.success(revenueFacade.nonCoveredDivision(request));
    }
}
