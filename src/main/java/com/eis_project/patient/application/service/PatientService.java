package com.eis_project.patient.application.service;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.patient.api.request.PatientIORequest;
import com.eis_project.patient.api.response.*;
import com.eis_project.patient.repository.PatientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName   : com.eis_project.patient.application.service
 * fileName      : PatientService
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 28.       김주한             최초생성
 * 26. 5. 27.       어 진              외래/입원 환자 수 조회 추가
*/

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientMapper patientMapper;

    public PatientOccupancyRateResponse getPatientOccupancyRate(CommonDateRequest request) {
        return patientMapper.getPatientOccupancyRate(request);
    }


    public List<PatientVisitRouteResponse> getPatientVisitRoute(PatientIORequest request) {
        return patientMapper.getPatientVisitRoute(request);
    }

    public List<PatientTrendResponse> getPatientTrend(PatientIORequest request) {
        return patientMapper.getPatientTrend(request);
    }

    public List<PatientVisitLocationResponse> getPatientVisitLocation(PatientIORequest request) {
        return patientMapper.getPatientVisitLocation(request);
    }
}
