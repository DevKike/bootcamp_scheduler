package com.onclass.bootcamp.adapters.driving.http.mapper;

import com.onclass.bootcamp.adapters.driving.http.dto.response.BootcampResponse;
import com.onclass.bootcamp.domain.model.Bootcamp;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBootcampResponseMapper {
    List<BootcampResponse> toBootcampResponseList(List<Bootcamp> bootcamps);
}
