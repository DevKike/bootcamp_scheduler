package com.bootcamp.scheduler.adapters.driving.http.mapper;

import com.bootcamp.scheduler.adapters.driving.http.dto.request.AddBootcampRequest;
import com.bootcamp.scheduler.domain.model.Bootcamp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IBootcampRequestMapper {
    @Mapping(target = "id", ignore = true)
    Bootcamp addRequestToBootcamp(AddBootcampRequest addBootcampRequest);
}