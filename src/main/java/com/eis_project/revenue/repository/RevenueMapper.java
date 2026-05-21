package com.eis_project.revenue.repository;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.common.CommonDeptRequest;
import com.eis_project.revenue.api.reponse.NonCoverDivisionResponse;
import com.eis_project.revenue.api.reponse.NonCoveredResponse;
import com.eis_project.revenue.api.reponse.RevenueDeptResponse;
import com.eis_project.revenue.api.reponse.RevenueResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RevenueMapper {
    List<RevenueDeptResponse> getRevenueDept(CommonDateRequest request);

    List<RevenueResponse> getRevenue(CommonDeptRequest request);

    List<NonCoveredResponse> getNonCovered(CommonDateRequest request);

    List<NonCoverDivisionResponse> getNonCoverDivision(CommonDateRequest request);
}
