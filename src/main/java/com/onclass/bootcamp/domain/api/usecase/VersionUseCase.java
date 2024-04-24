package com.onclass.bootcamp.domain.api.usecase;

import com.onclass.bootcamp.domain.api.IVersionServicePort;
import com.onclass.bootcamp.domain.model.Version;
import com.onclass.bootcamp.domain.spi.IVersionPersistencePort;

import java.util.List;

public class VersionUseCase implements IVersionServicePort {
    private final IVersionPersistencePort versionPersistencePort;

    public VersionUseCase(IVersionPersistencePort versionPersistencePort) {
        this.versionPersistencePort = versionPersistencePort;
    }

    @Override
    public void addVersion(Version version) {
        versionPersistencePort.addVersion(version);
    }

    @Override
    public List<Version> getAllBy(Integer page, Integer size, boolean isAscending, boolean orderByStartDate, boolean orderByMaxQuota) {
        return versionPersistencePort.getAllVersions(page, size, isAscending, orderByStartDate, orderByMaxQuota);
    }

    @Override
    public List<Version> getByBootcampId(Long bootcampId, Integer page, Integer size, boolean isAscending, boolean orderByStartDate, boolean orderByMaxQuota) {
        return versionPersistencePort.getByBootcampId(bootcampId, page, size, isAscending, orderByStartDate, orderByMaxQuota);
    }
}