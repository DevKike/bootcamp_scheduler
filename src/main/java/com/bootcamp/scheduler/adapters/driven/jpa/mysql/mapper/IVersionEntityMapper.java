package com.bootcamp.scheduler.adapters.driven.jpa.mysql.mapper;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.entity.VersionEntity;
import com.bootcamp.scheduler.domain.model.Version;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IVersionEntityMapper {
    VersionEntity toEntity(Version version);
}