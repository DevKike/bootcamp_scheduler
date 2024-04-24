package com.onclass.bootcamp.domain.api.usecase;

import com.onclass.bootcamp.domain.api.ICapacityServicePort;
import com.onclass.bootcamp.domain.model.Capacity;
import com.onclass.bootcamp.domain.spi.ICapacityPersistencePort;

import java.util.List;
import java.util.Set;

public class CapacityUseCase implements ICapacityServicePort {
    private final ICapacityPersistencePort capacityPersistencePort;

    public CapacityUseCase(ICapacityPersistencePort capacityPersistencePort) {
        this.capacityPersistencePort = capacityPersistencePort;
    }

    @Override
    public void addCapacity(Capacity capacity) {
        capacityPersistencePort.addCapacity(capacity);
    }

    @Override
    public void associateTechnologiesWithCapacity(Long capacityId, Set<Long> technologyIds) {
        capacityPersistencePort.associateTechnologiesWithCapacity(capacityId, technologyIds);
    }

    @Override
    public List<Capacity> getAllCapacities(Integer page, Integer size, boolean isAscending, boolean orderByTechCount) {
        return capacityPersistencePort.getAllCapacities(page, size, isAscending, orderByTechCount);
    }
}