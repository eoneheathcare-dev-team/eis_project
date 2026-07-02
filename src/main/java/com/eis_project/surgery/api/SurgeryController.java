package com.eis_project.surgery.api;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.common.CommonDeptRequest;
import com.eis_project.common.CommonResult;
import com.eis_project.surgery.api.response.OperationCntResponse;
import com.eis_project.surgery.api.response.SurgeryDeptResponse;
import com.eis_project.surgery.api.response.SurgeryResponse;
import com.eis_project.surgery.application.facade.SurgeryFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
 * 26. 5. 27.       어 진              수술 건수 조회 추가
 * 26. 7. 01.       김주한              요청값 유효성 검증 적용
 * 26. 7. 02.       김주한             수술 건수 조회 주석처리 (App 에서 미사용)
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
    public CommonResult<List<SurgeryDeptResponse>> surgeryDept (@Valid CommonDateRequest request) {
        return CommonResult.success(surgeryFacade.surgeryDept(request));
    }

    @Operation(summary = "수술 - 수술조회", description = "")
    @GetMapping("")
    public CommonResult<List<SurgeryResponse>> surgery (@Valid CommonDeptRequest request) {
        return CommonResult.success(surgeryFacade.surgery(request));
    }

    /*@Operation(summary = "수술 - 수술건수 조회", description = "")
    @GetMapping("/cnt/operations")
    public CommonResult<List<OperationCntResponse>> operationCnt (@Valid CommonDateRequest request) {
        return CommonResult.success(surgeryFacade.operationCnt(request));
    }*/
    
}
