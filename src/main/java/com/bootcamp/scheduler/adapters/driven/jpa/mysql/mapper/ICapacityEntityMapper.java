package com.bootcamp.scheduler.adapters.driven.jpa.mysql.mapper;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.entity.CapacityEntity;
import com.bootcamp.scheduler.domain.model.Capacity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICapacityEntityMapper {
    CapacityEntity toModel(Capacity capacity);
    List<Capacity> toEntityList(List<CapacityEntity> capacityEntities);
}