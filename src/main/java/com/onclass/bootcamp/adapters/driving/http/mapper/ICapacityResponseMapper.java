package com.onclass.bootcamp.adapters.driving.http.mapper;

import com.onclass.bootcamp.adapters.driving.http.dto.response.CapacityResponse;
import com.onclass.bootcamp.domain.model.Capacity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICapacityResponseMapper {
    List<CapacityResponse> toCapacityResponseList(List<Capacity> capacities);
}