package com.eis_project.patient.application.facade;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.patient.api.request.PatientIORequest;
import com.eis_project.patient.api.response.PatientOccupancyRateResponse;
import com.eis_project.patient.api.response.PatientTrendResponse;
import com.eis_project.patient.api.response.PatientVisitLocationResponse;
import com.eis_project.patient.api.response.PatientVisitRouteResponse;
import com.eis_project.patient.application.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName   : com.eis_project.patient.application.facade
 * fileName      : PatientFacade
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 4. 28.       김주한             최초생성
*/

@Service
@RequiredArgsConstructor
public class PatientFacade {
    private final PatientService patientService;

    public PatientOccupancyRateResponse patientOccupancyRate(CommonDateRequest request) {
        return patientService.getPatientOccupancyRate(request);
    }

    public List<PatientVisitRouteResponse> patientVisitRoute(PatientIORequest request) {
        return patientService.getPatientVisitRoute(request);
    }

    public List<PatientTrendResponse> patientTrend(PatientIORequest request) {
        return patientService.getPatientTrend(request);
    }

    public List<PatientVisitLocationResponse> patientVisitLocation(PatientIORequest request) {
        return patientService.getPatientVisitLocation(request);
    }
}
