package com.onclass.bootcamp.adapters.driving.http.mapper;

import com.onclass.bootcamp.adapters.driving.http.dto.response.VersionResponse;
import com.onclass.bootcamp.domain.model.Version;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IVersionResponseMapper {
    List<VersionResponse> toVersionResponseList(List<Version> version);
}