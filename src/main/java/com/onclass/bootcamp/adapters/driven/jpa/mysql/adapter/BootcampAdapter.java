package com.onclass.bootcamp.adapters.driven.jpa.mysql.adapter;

import com.onclass.bootcamp.adapters.driven.jpa.mysql.entity.BootcampEntity;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.entity.CapacityEntity;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.exception.AlreadyExistsException;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.exception.NotFoundException;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.mapper.IBootcampEntityMapper;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.repository.IBootcampRepository;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import com.onclass.bootcamp.domain.exception.SizeException;
import com.onclass.bootcamp.domain.model.Bootcamp;
import com.onclass.bootcamp.domain.spi.IBootcampPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.HashSet;
import java.util.List;
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

    @Override
    public List<Bootcamp> getAllBootcamps(Integer page, Integer size, boolean isAscending, boolean orderByCapCount) {
        Page<BootcampEntity> bootcampsPage;
        String direction = isAscending ? "ASC" : "DESC";
        Pageable pagination = PageRequest.of(page, size);
        Pageable sortedPagination = (PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), "name")));

        if (orderByCapCount) {
            if (isAscending) {
                bootcampsPage = bootcampRepository.findAllWitchCapacitiesOrderByAsc(pagination);
            } else {
                bootcampsPage = bootcampRepository.findAllWitchCapacitiesOrderByDesc(pagination);
            }
        } else {
            bootcampsPage = bootcampRepository.findAll(sortedPagination);
        }

        List<BootcampEntity> bootcamps = bootcampsPage.getContent();
        
        if (bootcamps.isEmpty()) {
            throw new NotFoundException("No registered bootcamps found");
        }
        
        return bootcampEntityMapper.toModelList(bootcamps);
    }
}