package com.bootcamp.scheduler.domain.api;

import com.bootcamp.scheduler.domain.model.Capacity;

import java.util.Set;

public interface ICapacityServicePort {
    void addCapacity(Capacity capacity);
    void associateTechnologiesWithCapacity(Long capacityId, Set<Long> technologyIds);
}