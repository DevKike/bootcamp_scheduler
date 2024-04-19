package com.bootcamp.scheduler.domain.api;

import com.bootcamp.scheduler.domain.model.Version;

public interface IVersionServicePort {
    void addVersion(Version version);
}