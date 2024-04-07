package com.bootcamp.scheduler.adapters.driving.http.mapper;

import com.bootcamp.scheduler.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.bootcamp.scheduler.adapters.driving.http.dto.response.TechnologyResponse;
import com.bootcamp.scheduler.domain.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITechnologyRequestMapper {
    @Mapping(target = "id", ignore = true)
    Technology addRequestToTechnology(AddTechnologyRequest addTechnologyRequest);
    List<TechnologyResponse> toTechnologyResponseList(List<Technology> technologies);
}