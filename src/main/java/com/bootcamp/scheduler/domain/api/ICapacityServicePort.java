package com.bootcamp.scheduler.domain.api;

import com.bootcamp.scheduler.domain.model.Capacity;

public interface ICapacityServicePort {
    void addCapacity(Capacity capacity);
}