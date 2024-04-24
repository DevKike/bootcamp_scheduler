package com.onclass.bootcamp.adapters.driven.jpa.mysql.adapter;

import com.onclass.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.exception.AlreadyExistsException;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.exception.NotFoundException;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.onclass.bootcamp.domain.model.Technology;
import com.onclass.bootcamp.domain.spi.ITechnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class TechnologyAdapter implements ITechnologyPersistencePort {
    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;

    @Override
    public void addTechnology(Technology technology) {
        if (technologyRepository.findByName(technology.getName()).isPresent()) {
            throw new AlreadyExistsException("Technology already exists");
        }
        technologyRepository.save(technologyEntityMapper.toEntity(technology));
    }

    @Override
    public List<Technology> getAllTechnologies(Integer page, Integer size, Sort sort) {
        Pageable pagination = PageRequest.of(page, size, sort);
        List<TechnologyEntity> technologies = technologyRepository.findAll(pagination).getContent();

        if (technologies.isEmpty()) {
            throw new NotFoundException("No registered technologies found");
        }
        return technologyEntityMapper.toModelList(technologies);
    }
}