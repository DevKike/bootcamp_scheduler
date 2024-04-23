package com.bootcamp.scheduler.domain.api.usecase;

import com.bootcamp.scheduler.domain.api.IBootcampServicePort;
import com.bootcamp.scheduler.domain.api.IVersionServicePort;
import com.bootcamp.scheduler.domain.model.Version;
import com.bootcamp.scheduler.domain.spi.IVersionPersistencePort;

public class VersionUseCase implements IVersionServicePort {
    private final IVersionPersistencePort versionPersistencePort;
    private final IBootcampServicePort bootcampServicePort;

    public VersionUseCase(IVersionPersistencePort versionPersistencePort, IBootcampServicePort bootcampServicePort) {
        this.versionPersistencePort = versionPersistencePort;
        this.bootcampServicePort = bootcampServicePort;
    }

    @Override
    public void addVersion(Version version) {
        versionPersistencePort.addVersion(version);
    }
}