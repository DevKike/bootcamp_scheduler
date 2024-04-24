package com.bootcamp.scheduler.domain.api;

import com.bootcamp.scheduler.domain.model.Version;

import java.util.List;

public interface IVersionServicePort {
    void addVersion(Version version);
    List<Version> getAllBy(Integer page, Integer size, boolean isAscending, boolean orderByStartDate, boolean orderByMaxQuota);
}