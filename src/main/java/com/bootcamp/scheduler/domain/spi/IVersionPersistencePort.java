package com.bootcamp.scheduler.domain.spi;

import com.bootcamp.scheduler.domain.model.Version;

import java.util.List;

public interface IVersionPersistencePort {
    void addVersion(Version version);
    List<Version> getAllVersions(Integer page, Integer size, boolean isAscending);
}