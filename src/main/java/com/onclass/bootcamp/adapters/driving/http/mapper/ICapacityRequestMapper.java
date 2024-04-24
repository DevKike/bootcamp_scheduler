package com.onclass.bootcamp.adapters.driving.http.mapper;

import com.onclass.bootcamp.adapters.driving.http.dto.request.AddCapacityRequest;
import com.onclass.bootcamp.adapters.driving.http.dto.response.CapacityResponse;
import com.onclass.bootcamp.domain.model.Capacity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICapacityRequestMapper {
    @Mapping(target = "id", ignore = true)
    Capacity addRequestToCapacity(AddCapacityRequest addCapacityRequest);
    List<CapacityResponse> toCapacityResponseList(List<Capacity> capacities);
}