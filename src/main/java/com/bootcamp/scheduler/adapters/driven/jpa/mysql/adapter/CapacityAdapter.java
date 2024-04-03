package com.bootcamp.scheduler.adapters.driven.jpa.mysql.adapter;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistsException;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.mapper.ICapacityEntityMapper;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import com.bootcamp.scheduler.domain.model.Capacity;
import com.bootcamp.scheduler.domain.spi.ICapacityPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CapacityAdapter implements ICapacityPersistencePort {
    private final ICapacityRepository capacityRepository;
    private final ICapacityEntityMapper capacityEntityMapper;

    @Override
    public void addCapacity(Capacity capacity) {
        if (capacityRepository.findByName(capacity.getName()).isPresent()) {
            throw new TechnologyAlreadyExistsException("Capacity already exists");
        }

        capacityRepository.save(capacityEntityMapper.toEntity(capacity));
    }
}