package com.technologies.microservice.domain.api.usecase;

import com.technologies.microservice.domain.api.ITechnologyServicePort;
import com.technologies.microservice.domain.model.Technology;
import com.technologies.microservice.domain.spi.ITechnologyPersistencePort;

public class TechnologyUseCase implements ITechnologyServicePort {
    private final ITechnologyPersistencePort technologyPersistencePort;

    public TechnologyUseCase(ITechnologyPersistencePort technologyPersistencePort) {
        this.technologyPersistencePort = technologyPersistencePort;
    }

    @Override
    public void addTechnology(Technology technology) {
        technologyPersistencePort.addTechnology(technology);
    }
}
