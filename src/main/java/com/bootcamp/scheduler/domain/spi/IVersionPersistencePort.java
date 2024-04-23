package com.bootcamp.scheduler.domain.spi;

import com.bootcamp.scheduler.domain.model.Version;

public interface IVersionPersistencePort {
    void addVersion(Version version);
}