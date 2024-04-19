package com.bootcamp.scheduler.adapters.driven.jpa.mysql.adapter;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.mapper.IVersionEntityMapper;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository.IVersionRepository;
import com.bootcamp.scheduler.domain.model.Version;
import com.bootcamp.scheduler.domain.spi.IVersionPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VersionAdapter implements IVersionPersistencePort {
    private final IVersionRepository versionRepository;
    private final IVersionEntityMapper versionEntityMapper;

    @Override
    public void addVersion(Version version) {
        versionRepository.save(versionEntityMapper.toEntity(version));
    }
}