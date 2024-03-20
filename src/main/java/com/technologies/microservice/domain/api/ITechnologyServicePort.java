package com.technologies.microservice.domain.api;

import com.technologies.microservice.domain.model.Technology;
import org.springframework.web.bind.annotation.RequestParam;

public interface ITechnologyServicePort {
    void saveTechnology(Technology technology);
}
