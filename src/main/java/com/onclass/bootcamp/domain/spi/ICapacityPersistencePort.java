package com.onclass.bootcamp.domain.spi;

import com.onclass.bootcamp.domain.model.Capacity;

import java.util.List;
import java.util.Set;

public interface ICapacityPersistencePort {
    void addCapacity(Capacity capacity);
    void associateTechnologiesWithCapacity(Long capacityId, Set<Long> technologyIds);
    List<Capacity> getAllCapacities(Integer page, Integer size, boolean isAscending, boolean orderByTechCount);
}