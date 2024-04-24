package com.bootcamp.scheduler.adapters.driving.http.mapper;

import com.bootcamp.scheduler.adapters.driving.http.dto.response.VersionResponse;
import com.bootcamp.scheduler.domain.model.Version;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IVersionResponseMapper {
    List<VersionResponse> toVersionResponseList(List<Version> version);
}