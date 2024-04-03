package com.bootcamp.scheduler.domain.api.usecase;

import com.bootcamp.scheduler.domain.api.ICapacityServicePort;
import com.bootcamp.scheduler.domain.model.Capacity;
import com.bootcamp.scheduler.domain.spi.ICapacityPersistencePort;

public class CapacityUseCase implements ICapacityServicePort {
    private final ICapacityPersistencePort capacityPersistencePort;

    public CapacityUseCase(ICapacityPersistencePort capacityPersistencePort) {
        this.capacityPersistencePort = capacityPersistencePort;
    }

    @Override
    public void addCapacity(Capacity capacity) {
        capacityPersistencePort.addCapacity(capacity);
    }
}