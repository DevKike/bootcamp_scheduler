package com.bootcamp.scheduler.domain.spi;

import com.bootcamp.scheduler.domain.model.Bootcamp;

import java.util.Set;

public interface IBootcampPersistencePort {
    void addBootcamp(Bootcamp bootcamp);
    void associateCapacitiesWithBootcamp(Long bootcampId, Set<Long> capacitiesIds);
}
