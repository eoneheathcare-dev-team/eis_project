package com.eis_project.dashboard.service;

import com.eis_project.dashboard.api.request.DashboardRequest;
import com.eis_project.dashboard.api.response.DashboardAmountResponse;
import com.eis_project.dashboard.api.response.DashboardCountResponse;
import com.eis_project.dashboard.api.response.DashboardSurgeryCountResponse;
import com.eis_project.dashboard.api.response.DashboardWardRateResponse;
import com.eis_project.dashboard.repository.DashboardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName   : com.eis_project.dashboard.service
 * fileName      : DashboardService
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 27.       김주한             최초생성
 * 26. 6. 01.       김주한             대시보드 병상, 수술, 환자수, 환자 총액 api 추가 및 기존 api 삭제
*/

@Service
@RequiredArgsConstructor
public class DashboardService {
    private final DashboardMapper mapper;

    public DashboardCountResponse dashboardPatientCount(DashboardRequest request) {
        return mapper.getPatientCount(request);
    }

    public DashboardAmountResponse dashboardPatientAmount(DashboardRequest request) {
        return mapper.getPatientAmount(request);
    }

    public DashboardSurgeryCountResponse dashboardSurgeryCount(DashboardRequest request) {
        return mapper.getSurgeryCount(request);
    }

    public DashboardWardRateResponse dashboardWardRate(DashboardRequest request) {
        return mapper.getWardRate(request);
    }
}
