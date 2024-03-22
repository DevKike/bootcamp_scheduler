package com.bootcamp.scheduler.adapters.driving.http.mapper;

import com.bootcamp.scheduler.adapters.driving.http.dto.response.TechnologyResponse;
import com.bootcamp.scheduler.domain.model.Technology;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITechnologyResponseMapper {
    List<TechnologyResponse> toTechnologyResponseList(List<Technology> technologies);
}