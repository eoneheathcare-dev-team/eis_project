package com.eis_project.patient.repository;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.patient.api.request.PatientIORequest;
import com.eis_project.patient.api.response.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatientMapper {

    PatientOccupancyRateResponse getPatientOccupancyRate(CommonDateRequest request);

    List<PatientVisitRouteResponse> getPatientVisitRoute(PatientIORequest request);

    List<PatientTrendResponse> getPatientTrend(PatientIORequest request);

    List<PatientVisitLocationResponse> getPatientVisitLocation(PatientIORequest request);
}
