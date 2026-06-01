package com.eis_project.dashboard.repository;

import com.eis_project.dashboard.api.request.DashboardRequest;
import com.eis_project.dashboard.api.response.DashboardAmountResponse;
import com.eis_project.dashboard.api.response.DashboardCountResponse;
import com.eis_project.dashboard.api.response.DashboardSurgeryCountResponse;
import com.eis_project.dashboard.api.response.DashboardWardRateResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DashboardMapper {
    DashboardCountResponse getPatientCount(DashboardRequest request);

    DashboardAmountResponse getPatientAmount(DashboardRequest request);

    DashboardSurgeryCountResponse getSurgeryCount(DashboardRequest request);

    DashboardWardRateResponse getWardRate(DashboardRequest request);
}
