package com.bootcamp.scheduler.adapters.driven.jpa.mysql.adapter;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.exception.AlreadyExistsException;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.mapper.IBootcampEntityMapper;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository.IBootcampRepository;
import com.bootcamp.scheduler.domain.model.Bootcamp;
import com.bootcamp.scheduler.domain.spi.IBootcampPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BootcampAdapter implements IBootcampPersistencePort {
    private final IBootcampRepository bootcampRepository;
    private final IBootcampEntityMapper bootcampEntityMapper;

    @Override
    public void addBootcamp(Bootcamp bootcamp) {
        if(bootcampRepository.findByName(bootcamp.getName()).isPresent()) {
            throw new AlreadyExistsException("Bootcamp already exists");
        }

        bootcampRepository.save(bootcampEntityMapper.toEntity(bootcamp));
    }
}