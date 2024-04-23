package com.bootcamp.scheduler.adapters.driven.jpa.mysql.adapter;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.exception.NotFoundException;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.mapper.IVersionEntityMapper;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository.IBootcampRepository;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository.IVersionRepository;
import com.bootcamp.scheduler.domain.model.Version;
import com.bootcamp.scheduler.domain.spi.IVersionPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VersionAdapter implements IVersionPersistencePort {
    private final IVersionRepository versionRepository;
    private final IBootcampRepository bootcampRepository;
    private final IVersionEntityMapper versionEntityMapper;

    @Override
    public void addVersion(Version version) {
        if (!bootcampRepository.existsById(version.getBootcamp().getId())) {
            throw new NotFoundException("No registered bootcamp found with id " + version.getBootcamp().getId());
        }

        versionRepository.save(versionEntityMapper.toEntity(version));
    }
}