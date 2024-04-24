package com.onclass.bootcamp.adapters.driven.jpa.mysql.adapter;

import com.onclass.bootcamp.adapters.driven.jpa.mysql.entity.CapacityEntity;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.exception.AlreadyExistsException;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.exception.NotFoundException;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.mapper.ICapacityEntityMapper;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.onclass.bootcamp.domain.exception.SizeException;
import com.onclass.bootcamp.domain.model.Capacity;
import com.onclass.bootcamp.domain.spi.ICapacityPersistencePort;
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

        if (capacityEntity.getTechnologies().size() + technologyIds.size() < 3) {
            throw new SizeException("Capacity must have at least 3 associated technologies");
        }

        if (capacityEntity.getTechnologies().size() + technologyIds.size() > 20) {
            throw new SizeException("Capacity can have maximum 20 associated technologies");
        }

        for (Long technologyId : technologyIds) {
            boolean technologyExists = capacityEntity.getTechnologies().stream()
                    .anyMatch(tech -> tech.getId().equals(technologyId));
            if (technologyExists) {
                throw new AlreadyExistsException("Capacity already has technology with id: " + technologyId);
            }
        }

        Set<TechnologyEntity> newTechnologies = new HashSet<>();
        for (Long technologyId : technologyIds) {
            Optional<TechnologyEntity> technologyOptional = technologyRepository.findById(technologyId);
            if (technologyOptional.isPresent()) {
                newTechnologies.add(technologyOptional.get());
            } else {
                throw new NotFoundException("Technology with id " + technologyId + " not found");
            }
        }

        capacityEntity.getTechnologies().addAll(newTechnologies);
        capacityRepository.save(capacityEntity);
    }

    @Override
    public List<Capacity> getAllCapacities(Integer page, Integer size, boolean isAscending, boolean orderByTechCount) {
        Page<CapacityEntity> capacitiesPage;
        String direction = isAscending ? "ASC" : "DESC";
        Pageable pagination = PageRequest.of(page, size);
        Pageable sortPagination = (PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), "name")));

        if (orderByTechCount) {
            if (isAscending) {
                capacitiesPage = capacityRepository.findAllWithTechnologiesOrderByAsc(pagination);
            } else {
                capacitiesPage = capacityRepository.findAllWithTechnologiesOrderByDesc(pagination);
            }
        } else {
            capacitiesPage = capacityRepository.findAll(sortPagination);
        }

        List<CapacityEntity> capacities = capacitiesPage.getContent();

        if (capacities.isEmpty()) {
            throw new NotFoundException("No registered capacities found");
        }

        return capacityEntityMapper.toModelList(capacities);
    }
}