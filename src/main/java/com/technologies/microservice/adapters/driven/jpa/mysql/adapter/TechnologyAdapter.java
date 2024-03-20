package com.technologies.microservice.adapters.driven.jpa.mysql.adapter;

import com.technologies.microservice.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.technologies.microservice.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.technologies.microservice.domain.spi.ITechnologyPersistencePort;
import com.technologies.microservice.domain.model.Technology;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TechnologyAdapter implements ITechnologyPersistencePort {
    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;


    @Override
    public void addTechnology(Technology technology) {
        technologyRepository.save(technologyEntityMapper.toEntity(technology));
    }
}
