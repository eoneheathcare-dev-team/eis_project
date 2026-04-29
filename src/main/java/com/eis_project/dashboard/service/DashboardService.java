package com.eis_project.dashboard.service;

import com.eis_project.dashboard.api.request.DashboardRequest;
import com.eis_project.dashboard.api.response.DashboardResponse;
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
*/

@Service
@RequiredArgsConstructor
public class DashboardService {
    private final DashboardMapper dashboardMapper;
    public DashboardResponse dashboard(DashboardRequest request) {
        return dashboardMapper.getDashboardInfo(request);
    }
}
