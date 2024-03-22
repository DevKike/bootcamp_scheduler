package com.bootcamp.scheduler.domain.spi;

import com.bootcamp.scheduler.domain.model.Technology;

public interface ITechnologyPersistencePort {
    void addTechnology(Technology technology);
}