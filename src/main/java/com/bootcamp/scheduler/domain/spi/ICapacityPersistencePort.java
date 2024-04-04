package com.bootcamp.scheduler.domain.spi;

import com.bootcamp.scheduler.domain.model.Capacity;

import java.util.Set;

public interface ICapacityPersistencePort {
    void addCapacity(Capacity capacity);
    void associateTechnologiesWithCapacity(Long capacityId, Set<Long> technologyIds);
}