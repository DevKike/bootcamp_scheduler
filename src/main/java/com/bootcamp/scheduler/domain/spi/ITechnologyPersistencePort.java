package com.bootcamp.scheduler.domain.spi;

import com.bootcamp.scheduler.domain.model.Technology;

import java.util.List;

public interface ITechnologyPersistencePort {
    void addTechnology(Technology technology);
    List<Technology> getAllTechnologies(Integer page, Integer size);
}