package com.bootcamp.scheduler.domain.api.usecase;

import com.bootcamp.scheduler.domain.api.ICapacityServicePort;
import com.bootcamp.scheduler.domain.model.Capacity;

public class CapacityUseCase implements ICapacityServicePort {
    private final ICapacityServicePort capacityServicePort;

    public CapacityUseCase(ICapacityServicePort capacityServicePort) {
        this.capacityServicePort = capacityServicePort;
    }

    @Override
    public void addCapacity(Capacity capacity) {
        capacityServicePort.addCapacity(capacity);
    }
}