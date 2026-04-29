package com.eis_project.surgery.api;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.common.CommonDeptRequest;
import com.eis_project.common.CommonResult;
import com.eis_project.surgery.api.response.SurgeryDeptResponse;
import com.eis_project.surgery.api.response.SurgeryResponse;
import com.eis_project.surgery.application.facade.SurgeryFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName   : com.eis_project.surgery.api
 * fileName      : SurgeryController
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 28.       김주한             최초생성
*/

@Tag(name = "Surgery", description = "수술 통계 API")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/surgery")
public class SurgeryController {
    private final SurgeryFacade surgeryFacade;

    @Operation(summary = "수술 - 부서조회", description = "")
    @GetMapping("/dept")
    public CommonResult<List<SurgeryDeptResponse>> surgeryDept (CommonDateRequest request) {
        return CommonResult.success(surgeryFacade.surgeryDept(request));
    }

    @Operation(summary = "수술 - 수술조회", description = "")
    @GetMapping("")
    public CommonResult<List<SurgeryResponse>> surgery (CommonDeptRequest request) {
        return CommonResult.success(surgeryFacade.surgery(request));
    }
    
}
