package com.onclass.bootcamp.domain.api;

import com.onclass.bootcamp.domain.model.Technology;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ITechnologyServicePort {
    void addTechnology(Technology technology);
    List<Technology> getAllTechnologies(Integer page, Integer size, Sort.Direction direction);
}