package com.bootcamp.scheduler.adapters.driven.jpa.mysql.adapter;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.entity.BootcampEntity;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.entity.CapacityEntity;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.exception.AlreadyExistsException;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.exception.NotFoundException;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.mapper.IBootcampEntityMapper;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository.IBootcampRepository;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import com.bootcamp.scheduler.domain.exception.SizeException;
import com.bootcamp.scheduler.domain.model.Bootcamp;
import com.bootcamp.scheduler.domain.spi.IBootcampPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
public class BootcampAdapter implements IBootcampPersistencePort {
    private final IBootcampRepository bootcampRepository;
    private final IBootcampEntityMapper bootcampEntityMapper;
    private final ICapacityRepository capacityRepository;

    @Override
    public void addBootcamp(Bootcamp bootcamp) {
        if(bootcampRepository.findByName(bootcamp.getName()).isPresent()) {
            throw new AlreadyExistsException("Bootcamp already exists");
        }

        bootcampRepository.save(bootcampEntityMapper.toEntity(bootcamp));
    }

    @Override
    public void associateCapacitiesWithBootcamp(Long bootcampId, Set<Long> capacitiesIds) {
        Optional<BootcampEntity> bootcampOptional = bootcampRepository.findById(bootcampId);

        if (bootcampOptional.isEmpty()) {
            throw new NotFoundException("Bootcamp was not found");
        }

        BootcampEntity bootcampEntity = bootcampOptional.get();

        if (bootcampEntity.getCapacities().size() + capacitiesIds.size() < 1) {
            throw new SizeException("Bootcamp must have at least 1 associated capacities");
        }

        if (bootcampEntity.getCapacities().size() + capacitiesIds.size() > 4) {
            throw new SizeException("Bootcamp can have maximum 4 associated capacities");
        }

        for (Long capacityId : capacitiesIds) {
            boolean capacityExists = bootcampEntity.getCapacities().stream()
                    .anyMatch(cap -> cap.getId().equals(capacityId));
            if (capacityExists) {
                throw new AlreadyExistsException("Bootcamp already has capacity with id: " + capacityId);
            }
        }

        Set<CapacityEntity> newCapacities = new HashSet<>();
        for (Long capacityId : capacitiesIds) {
            Optional<CapacityEntity> capacityOptional = capacityRepository.findById(capacityId);
            if (capacityOptional.isPresent()) {
                newCapacities.add(capacityOptional.get());
            } else {
                throw new NotFoundException("Capacity with id " + capacityId + " not found");
            }
        }

        bootcampEntity.getCapacities().addAll(newCapacities);
        bootcampRepository.save(bootcampEntity);
    }
}