package com.eis_project.ward.repository;

import com.eis_project.common.CommonDateRequest;
import com.eis_project.ward.api.response.BedOccupancyRateResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WardMapper {
    List<BedOccupancyRateResponse> getBedOccupancyRate(CommonDateRequest request);
}
