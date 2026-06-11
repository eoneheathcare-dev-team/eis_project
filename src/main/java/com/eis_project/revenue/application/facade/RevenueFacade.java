package com.eis_project.revenue.application.facade;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.common.CommonDeptRequest;
import com.eis_project.common.CommonMedfeeRequest;
import com.eis_project.revenue.api.reponse.*;
import com.eis_project.revenue.application.service.RevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName   : com.eis_project.revenue.application.facade
 * fileName      : RevenueFacade
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 28.       김주한             최초생성
 * 26. 5. 27.       어 진              입원/외래 총 진료비 조회 추가
*/

@Service
@RequiredArgsConstructor
public class RevenueFacade {
    private final RevenueService revenueService;
    public List<RevenueDeptResponse> revenueDept(CommonDateRequest request) {
        return revenueService.getRevenueDept(request);
    }

    public List<RevenueResponse> revenue(CommonDeptRequest request) {
        return revenueService.getRevenue(request);
    }

    public List<NonCoveredResponse> nonCovered(CommonDateRequest request) {
        return revenueService.getNonCovered(request);
    }

    public List<NonCoverDivisionResponse> nonCoveredDivision(CommonDateRequest request) {
        return revenueService.getNonCoverDivision(request);
    }

    public List<TotalClinicRevenueResponse> totalClinicRevenue(String searchYmd) {
        return revenueService.getTotalClinicRevenue(searchYmd);
    }

    public List<NonCoveredItemResponse> nonCoveredItem(CommonDateRequest request) {
        return revenueService.getNonCoveredItem(request);
    }

    public List<NonCoveredTransitionResponse> nonCoveredTransition(CommonDateRequest request) {
        return revenueService.getNonCoveredTransition(request);
    }

    public List<NonCoveredDepartmentResponse> nonCoveredDepartment(CommonDateRequest request) {
        return revenueService.getNonCoveredDepartment(request);
    }

    public List<NonCoveredMainResponse> nonCoveredMain(CommonDateRequest request) {
        return revenueService.getNonCoveredMain(request);
    }

    public List<NonCoveredDetailResponse> nonCoveredDetail(CommonMedfeeRequest request) {
        return revenueService.getNonCoveredDetail(request);
    }
}
