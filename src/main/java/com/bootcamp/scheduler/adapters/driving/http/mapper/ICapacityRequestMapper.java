package com.bootcamp.scheduler.adapters.driving.http.mapper;

import com.bootcamp.scheduler.adapters.driving.http.dto.request.AddCapacityRequest;
import com.bootcamp.scheduler.domain.model.Capacity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICapacityRequestMapper {
    @Mapping(target = "id", ignore = true)
    Capacity addRequestToCapacity(AddCapacityRequest addCapacityRequest);
}