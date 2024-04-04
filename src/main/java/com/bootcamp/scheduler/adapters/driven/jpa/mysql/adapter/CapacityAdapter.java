package com.bootcamp.scheduler.adapters.driven.jpa.mysql.adapter;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.entity.CapacityEntity;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.exception.AlreadyExistsException;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.exception.NotFoundException;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.mapper.ICapacityEntityMapper;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.bootcamp.scheduler.domain.model.Capacity;
import com.bootcamp.scheduler.domain.spi.ICapacityPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
public class CapacityAdapter implements ICapacityPersistencePort {
    private final ICapacityRepository capacityRepository;
    private final ITechnologyRepository technologyRepository;
    private final ICapacityEntityMapper capacityEntityMapper;

    @Override
    public void addCapacity(Capacity capacity) {
        if (capacityRepository.findByName(capacity.getName()).isPresent()) {
            throw new AlreadyExistsException("Capacity already exists");
        }

        capacityRepository.save(capacityEntityMapper.toEntity(capacity));
    }

    @Override
    public void associateTechnologiesWithCapacity(Long capacityId, Set<Long> technologyIds) {
        Optional<CapacityEntity> capacityOptional = capacityRepository.findById(capacityId);

        if (capacityOptional.isEmpty()) {
            throw new NotFoundException("Capacity was not found");
        }

        CapacityEntity capacityEntity = capacityOptional.get();

        // Crear un conjunto para almacenar las entidades de tecnología asociadas
        Set<TechnologyEntity> technologyEntities = new HashSet<>();

        // Iterar sobre los identificadores de tecnología y buscar las entidades correspondientes
        for (Long technologyId : technologyIds) {
            Optional<TechnologyEntity> technologyOptional = technologyRepository.findById(technologyId);
            technologyOptional.ifPresent(technologyEntities::add);
        }

        // Asignar las tecnologías recuperadas al conjunto de tecnologías de la capacidad
        capacityEntity.setTechnologies(technologyEntities);

        // Guardar los cambios en la base de datos
        capacityRepository.save(capacityEntity);
    }
}