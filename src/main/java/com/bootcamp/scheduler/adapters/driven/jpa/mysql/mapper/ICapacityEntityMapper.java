package com.bootcamp.scheduler.adapters.driven.jpa.mysql.mapper;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.entity.CapacityEntity;
import com.bootcamp.scheduler.domain.model.Capacity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICapacityEntityMapper {
    CapacityEntity toEntity(Capacity capacity);
}