package com.bootcamp.scheduler.adapters.driving.http.mapper;

import com.bootcamp.scheduler.adapters.driving.http.dto.response.BootcampResponse;
import com.bootcamp.scheduler.domain.model.Bootcamp;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBootcampResponseMapper {
    List<BootcampResponse> toBootcampResponseList(List<Bootcamp> bootcamps);
}
