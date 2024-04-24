package com.onclass.bootcamp.adapters.driving.http.mapper;

import com.onclass.bootcamp.adapters.driving.http.dto.request.AddVersionRequest;
import com.onclass.bootcamp.domain.model.Version;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IVersionRequestMapper {
    @Mapping(target = "id", ignore = true)
    Version addRequestToVersion(AddVersionRequest addVersionRequest);
}