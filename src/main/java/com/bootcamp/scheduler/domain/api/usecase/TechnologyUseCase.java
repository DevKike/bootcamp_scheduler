package com.bootcamp.scheduler.domain.api.usecase;

import com.bootcamp.scheduler.domain.api.ITechnologyServicePort;
import com.bootcamp.scheduler.domain.model.Technology;
import com.bootcamp.scheduler.domain.spi.ITechnologyPersistencePort;
import org.springframework.data.domain.Sort;

import java.util.List;

public class TechnologyUseCase implements ITechnologyServicePort {
    private final ITechnologyPersistencePort technologyPersistencePort;

    public TechnologyUseCase(ITechnologyPersistencePort technologyPersistencePort) {
        this.technologyPersistencePort = technologyPersistencePort;
    }

    @Override
    public void addTechnology(Technology technology) {
        technologyPersistencePort.addTechnology(technology);
    }

    @Override
    public List<Technology> getAllTechnologies(Integer page, Integer size, Sort.Direction direction) {
        Sort sort = Sort.by(direction, "name");
        return technologyPersistencePort.getAllTechnologies(page, size, sort);
    }
}