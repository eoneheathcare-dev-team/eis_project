package com.eis_project.ward.application.service;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.ward.api.response.BedOccupancyRateResponse;
import com.eis_project.ward.repository.WardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName   : com.eis_project.ward.application.service
 * fileName      : WardService
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 5. 27.       어 진              최초생성
*/

@Service
@RequiredArgsConstructor
public class WardService {
    private final WardMapper wardMapper;

    public List<BedOccupancyRateResponse> getBedOccupancyRate(CommonDateRequest request) {
        return wardMapper.getBedOccupancyRate(request);
    }
}
