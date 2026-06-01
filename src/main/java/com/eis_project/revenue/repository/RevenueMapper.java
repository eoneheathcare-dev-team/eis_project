package com.eis_project.revenue.repository;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.common.CommonDeptRequest;
import com.eis_project.common.CommonMedfeeRequest;
import com.eis_project.revenue.api.reponse.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RevenueMapper {
    List<RevenueDeptResponse> getRevenueDept(CommonDateRequest request);

    List<RevenueResponse> getRevenue(CommonDeptRequest request);

    List<NonCoveredResponse> getNonCovered(CommonDateRequest request);

    List<NonCoverDivisionResponse> getNonCoverDivision(CommonDateRequest request);

    List<TotalClinicRevenueResponse> getTotalClinicRevenue(CommonDateRequest request);

    List<NonCoveredItemResponse> getNonCoveredItem(CommonDateRequest request);

    List<NonCoveredTransitionResponse> getNonCoveredTransition(CommonDateRequest request);

    List<NonCoveredDepartmentResponse> getNonCoveredDepartment(CommonDateRequest request);

    List<NonCoveredMainResponse> getNonCoveredMain(CommonDateRequest request);

    List<NonCoveredDetailResponse> getNonCoveredDetail(CommonMedfeeRequest request);
}
