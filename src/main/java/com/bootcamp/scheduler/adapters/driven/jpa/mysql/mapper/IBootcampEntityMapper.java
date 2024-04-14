package com.bootcamp.scheduler.adapters.driven.jpa.mysql.mapper;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.entity.BootcampEntity;
import com.bootcamp.scheduler.domain.model.Bootcamp;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IBootcampEntityMapper {
    BootcampEntity toEntity(Bootcamp bootcamp);
}