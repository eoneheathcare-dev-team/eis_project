package com.eis_project.ward.api;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.common.CommonResult;
import com.eis_project.ward.api.response.BedOccupancyRateResponse;
import com.eis_project.ward.application.facade.WardFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName   : com.eis_project.ward.api
 * fileName      : WardController
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 5. 27.       어 진              최초생성
*/

@Tag(name = "Ward", description = "병동 통계 API")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/ward")
public class WardController {
    private final WardFacade wardFacade;

    @Operation(summary = "병상가동률", description = "")
    @GetMapping("/bed-occupancy-rate")
    public CommonResult<List<BedOccupancyRateResponse>> bedOccupancyRate (CommonDateRequest request) {
        return CommonResult.success(wardFacade.bedOccupancyRate(request));
    }
    
}
