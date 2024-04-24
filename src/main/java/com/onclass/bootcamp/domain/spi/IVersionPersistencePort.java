package com.onclass.bootcamp.domain.spi;

import com.onclass.bootcamp.domain.model.Version;

import java.util.List;

public interface IVersionPersistencePort {
    void addVersion(Version version);
    List<Version> getAllVersions(Integer page, Integer size, boolean isAscending, boolean orderByStartDate, boolean orderByMaxQuota);
    List<Version> getByBootcampId(Long bootcampId, Integer page, Integer size, boolean isAscending, boolean orderByStartDate, boolean orderByMaxQuota);
}