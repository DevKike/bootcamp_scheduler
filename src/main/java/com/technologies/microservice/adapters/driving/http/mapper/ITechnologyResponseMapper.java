package com.technologies.microservice.adapters.driving.http.mapper;

import com.technologies.microservice.adapters.driving.http.dto.response.TechnologyResponse;
import com.technologies.microservice.domain.model.Technology;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITechnologyResponseMapper {
    TechnologyResponse toTechnologyResponse(Technology technology);
}
