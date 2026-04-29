package com.eis_project.dashboard.repository;

import com.eis_project.dashboard.api.request.DashboardRequest;
import com.eis_project.dashboard.api.response.DashboardResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DashboardMapper {
    DashboardResponse getDashboardInfo(DashboardRequest request);
}
