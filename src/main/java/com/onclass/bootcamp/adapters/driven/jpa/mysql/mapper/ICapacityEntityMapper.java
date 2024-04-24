package com.onclass.bootcamp.adapters.driven.jpa.mysql.mapper;

import com.onclass.bootcamp.adapters.driven.jpa.mysql.entity.CapacityEntity;
import com.onclass.bootcamp.domain.model.Capacity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICapacityEntityMapper {

    @Mapping(source = "technologies", target = "technologies")
    Capacity toModel(CapacityEntity capacityEntity);

    @Mapping(target = "technologies", source = "technologies")
    CapacityEntity toEntity(Capacity capacity);

    List<Capacity> toModelList(List<CapacityEntity> capacityEntities);
}