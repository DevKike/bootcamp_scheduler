package com.bootcamp.scheduler.adapters.driven.jpa.mysql.mapper;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.entity.BootcampEntity;
import com.bootcamp.scheduler.domain.model.Bootcamp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBootcampEntityMapper {
    @Mapping(target = "capacities", source= "capacities")
    BootcampEntity toEntity(Bootcamp bootcamp);

    List<Bootcamp> toModelList(List<BootcampEntity> bootcampEntities);
}