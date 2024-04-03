package com.bootcamp.scheduler.domain.spi;

import com.bootcamp.scheduler.domain.model.Capacity;

public interface ICapacityPersistencePort {
    void addCapacity(Capacity capacity);
}