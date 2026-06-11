package com.eis_project.surgery.repository;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.common.CommonDeptRequest;
import com.eis_project.surgery.api.response.OperationCntResponse;
import com.eis_project.surgery.api.response.SurgeryDeptResponse;
import com.eis_project.surgery.api.response.SurgeryResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SurgeryMapper {
    List<SurgeryDeptResponse> getSurgeryDept(CommonDateRequest request);

    List<SurgeryResponse> getSurgeryList(CommonDeptRequest request);

    List<OperationCntResponse> getOperationCnt(CommonDateRequest request);
}
