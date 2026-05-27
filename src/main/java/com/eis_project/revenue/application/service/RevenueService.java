package com.eis_project.revenue.application.service;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.common.CommonDeptRequest;
import com.eis_project.revenue.api.reponse.*;
import com.eis_project.revenue.repository.RevenueMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName   : com.eis_project.revenue.application.service
 * fileName      : RevenueService
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 28.       김주한             최초생성
 * 26. 5. 27.       어 진              입원/외래 총 진료비 조회 추가
*/

@Service
@RequiredArgsConstructor
public class RevenueService {
    private final RevenueMapper mapper;

    public List<RevenueDeptResponse> getRevenueDept(CommonDateRequest request) {
        return mapper.getRevenueDept(request);
    }

    public List<RevenueResponse> getRevenue(CommonDeptRequest request) {
        return mapper.getRevenue(request);
    }

    public List<NonCoveredResponse> getNonCovered(CommonDateRequest request) {
        return mapper.getNonCovered(request);
    }

    public List<NonCoverDivisionResponse> getNonCoverDivision(CommonDateRequest request) {
        return mapper.getNonCoverDivision(request);
    }

    public List<TotalClinicRevenueResponse> getTotalClinicRevenue(CommonDateRequest request) {
        return mapper.getTotalClinicRevenue(request);
    }
}
