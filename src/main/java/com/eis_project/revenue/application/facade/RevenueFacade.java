package com.eis_project.revenue.application.facade;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.common.CommonDeptRequest;
import com.eis_project.revenue.api.reponse.NonCoveredResponse;
import com.eis_project.revenue.api.reponse.RevenueDeptResponse;
import com.eis_project.revenue.api.reponse.RevenueResponse;
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
}
