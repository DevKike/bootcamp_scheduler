package com.bootcamp.scheduler.domain.spi;

import com.bootcamp.scheduler.domain.model.Capacity;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Set;

public interface ICapacityPersistencePort {
    void addCapacity(Capacity capacity);
    void associateTechnologiesWithCapacity(Long capacityId, Set<Long> technologyIds);
    List<Capacity> getAllCapacities(Integer page, Integer size, Sort sort, boolean sortByTechnologiesCount);
}