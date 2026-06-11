package com.eis_project.patient.api;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.common.CommonResult;
import com.eis_project.patient.api.request.PatientIORequest;
import com.eis_project.patient.api.response.*;
import com.eis_project.patient.application.facade.PatientFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** 
 * packageName   : com.eis_project.patient.api
 * fileName      : PatientController
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 28.       김주한             최초생성
 * 26. 5. 27.       어 진              외래/입원 환자 수 조회 추가
*/

@Tag(name = "Patient", description = "환자 통계 API")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/patient")
public class PatientController {
    private final PatientFacade patientFacade;

    @Operation(summary = "환자 점유율 조회", description = "")
    @GetMapping("/occupancy-rate")
    public CommonResult<PatientOccupancyRateResponse> patientOccupancyRate (CommonDateRequest request) {
        return CommonResult.success(patientFacade.patientOccupancyRate(request));
    }

    @Operation(summary = "환자 내원경로 조회", description = "")
    @GetMapping("/visit-route")
    public CommonResult<List<PatientVisitRouteResponse>> patientVisitRoute (PatientIORequest request) {
        return CommonResult.success(patientFacade.patientVisitRoute(request));
    }

    @Operation(summary = "환자 추이", description = "")
    @GetMapping("/trend")
    public CommonResult<List<PatientTrendResponse>> patientTrend (PatientIORequest request) {
        return CommonResult.success(patientFacade.patientTrend(request));
    }

    @Operation(summary = "지역별 환자 유입 경로", description = "")
    @GetMapping("/visit-location")
    public CommonResult<List<PatientVisitLocationResponse>> patientVisitLocation (PatientIORequest request) {
        return CommonResult.success(patientFacade.patientVisitLocation(request));
    }

    @Operation(summary = "외래/입원 환자 수", description = "")
    @GetMapping("/cnt")
    public CommonResult<List<PatientIOCntResponse>> patientIOCnt (CommonDateRequest request) {
        return CommonResult.success(patientFacade.patientIOCnt(request));
    }
}
