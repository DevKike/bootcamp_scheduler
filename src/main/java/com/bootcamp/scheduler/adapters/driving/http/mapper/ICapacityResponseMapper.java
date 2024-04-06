package com.bootcamp.scheduler.adapters.driving.http.mapper;

import com.bootcamp.scheduler.adapters.driving.http.dto.response.CapacityResponse;
import com.bootcamp.scheduler.domain.model.Capacity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICapacityResponseMapper {
    List<CapacityResponse> toCapacityResponseList(List<Capacity> capacities);
}