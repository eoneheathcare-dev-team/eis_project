package com.eis_project.surgery.application.service;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.common.CommonDeptRequest;
import com.eis_project.surgery.api.response.OperationCntResponse;
import com.eis_project.surgery.api.response.SurgeryDeptResponse;
import com.eis_project.surgery.api.response.SurgeryResponse;
import com.eis_project.surgery.repository.SurgeryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName   : com.eis_project.surgery.application.service
 * fileName      : SurgeryService
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 28.       김주한             최초생성
 * 26. 5. 27.       어 진              수술 건수 조회 추가
*/

@Service
@RequiredArgsConstructor
public class SurgeryService {
    private final SurgeryMapper surgeryMapper;

    public List<SurgeryDeptResponse> getSurgeryDept(CommonDateRequest request) {
        return surgeryMapper.getSurgeryDept(request);
    }

    public List<SurgeryResponse> getSurgeryList(CommonDeptRequest request) {
        return surgeryMapper.getSurgeryList(request);
    }

    public List<OperationCntResponse> getOperationCnt(CommonDateRequest request) {
        return surgeryMapper.getOperationCnt(request);
    }
}
