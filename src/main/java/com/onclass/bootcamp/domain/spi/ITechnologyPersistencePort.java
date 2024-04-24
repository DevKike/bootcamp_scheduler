package com.onclass.bootcamp.domain.spi;

import com.onclass.bootcamp.domain.model.Technology;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ITechnologyPersistencePort {
    void addTechnology(Technology technology);
    List<Technology> getAllTechnologies(Integer page, Integer size, Sort sort);
}