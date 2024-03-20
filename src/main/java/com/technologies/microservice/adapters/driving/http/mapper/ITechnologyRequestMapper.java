package com.technologies.microservice.adapters.driving.http.mapper;

import com.technologies.microservice.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.technologies.microservice.domain.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ITechnologyRequestMapper {
    @Mapping(target = "id", ignore = true)
    Technology addRequestToTechnology(AddTechnologyRequest addTechnologyRequest);
}
