package com.technologies.microservice.domain.spi;

import com.technologies.microservice.domain.model.Technology;

public interface ITechnologyPersistencePort {
    void addTechnology(Technology technology);
}
