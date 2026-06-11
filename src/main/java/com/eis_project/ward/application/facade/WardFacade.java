package com.eis_project.ward.application.facade;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.ward.api.response.BedOccupancyRateResponse;
import com.eis_project.ward.application.service.WardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName   : com.eis_project.ward.application.facade
 * fileName      : WardFacade
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 5. 27.       어 진              최초생성
*/

@Service
@RequiredArgsConstructor
public class WardFacade {
    private final WardService wardService;

    public List<BedOccupancyRateResponse> bedOccupancyRate(CommonDateRequest request) {
        return wardService.getBedOccupancyRate(request);
    }
}
