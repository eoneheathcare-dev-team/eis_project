package com.eis_project.revenue.application.service;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.common.CommonDeptRequest;
import com.eis_project.revenue.api.reponse.NonCoveredResponse;
import com.eis_project.revenue.api.reponse.RevenueDeptResponse;
import com.eis_project.revenue.api.reponse.RevenueResponse;
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
}
