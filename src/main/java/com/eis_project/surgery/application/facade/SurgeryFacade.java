package com.eis_project.surgery.application.facade;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.common.CommonDeptRequest;
import com.eis_project.surgery.api.response.OperationCntResponse;
import com.eis_project.surgery.api.response.SurgeryDeptResponse;
import com.eis_project.surgery.api.response.SurgeryResponse;
import com.eis_project.surgery.application.service.SurgeryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName   : com.eis_project.surgery.application.facade
 * fileName      : SurgeryFacade
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 28.       김주한             최초생성
 * 26. 5. 27.       어 진              수술 건수 조회 추가
*/

@Service
@RequiredArgsConstructor
public class SurgeryFacade {
    private final SurgeryService surgeryService;

    public List<SurgeryDeptResponse> surgeryDept(CommonDateRequest request) {
        return surgeryService.getSurgeryDept(request);
    }

    public List<SurgeryResponse> surgery(CommonDeptRequest request) {
        return surgeryService.getSurgeryList(request);
    }

    public List<OperationCntResponse> operationCnt(CommonDateRequest request) {
        return surgeryService.getOperationCnt(request);
    }
}
