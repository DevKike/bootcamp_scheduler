package com.technologies.microservice.domain.api;

import com.technologies.microservice.domain.model.Technology;

public interface ITechnologyServicePort {
    void saveTechnology(Technology technology);
}
