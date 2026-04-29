package com.eis_project.dashboard.api;

import com.eis_project.common.CommonResult;
import com.eis_project.dashboard.api.request.DashboardRequest;
import com.eis_project.dashboard.api.response.DashboardResponse;
import com.eis_project.dashboard.service.DashboardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName   : com.eis_project.dashboard.api
 * fileName      : DashboardController
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 27.       김주한             최초생성
*/

@Tag(name = "Dashboard", description = "대시보드 통계 API")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/dashboard")
public class DashboardController {
    private final DashboardService dashboardService;

    @Operation(summary = "통계 데이터 조회", description = "메인 대시보드에 필요한 환자수 및 진료비 데이터를 반환합니다.")
    @GetMapping("")
    public CommonResult<DashboardResponse> dashboard (DashboardRequest request) {
        return CommonResult.success(dashboardService.dashboard(request));
    }
}
