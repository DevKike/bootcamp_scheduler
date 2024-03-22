package com.bootcamp.scheduler.domain.api.usecase;

import com.bootcamp.scheduler.domain.api.ITechnologyServicePort;
import com.bootcamp.scheduler.domain.model.Technology;
import com.bootcamp.scheduler.domain.spi.ITechnologyPersistencePort;

import java.util.Comparator;
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
    public List<Technology> getAllTechnologies(Integer page, Integer size, SortDirection direction) {
        List<Technology> technologies = technologyPersistencePort.getAllTechnologies(page, size);
        if (direction == SortDirection.ASC) {
            technologies.sort(Comparator.comparing(Technology::getName));
        } else if (direction == SortDirection.DESC){
            technologies.sort(Comparator.comparing(Technology::getName).reversed());
        }
        return technologies;
    }
}