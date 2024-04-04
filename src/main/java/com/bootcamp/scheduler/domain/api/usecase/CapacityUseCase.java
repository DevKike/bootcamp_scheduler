package com.bootcamp.scheduler.domain.api.usecase;

import com.bootcamp.scheduler.domain.api.ICapacityServicePort;
import com.bootcamp.scheduler.domain.model.Capacity;
import com.bootcamp.scheduler.domain.spi.ICapacityPersistencePort;

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
}