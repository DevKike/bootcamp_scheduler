package com.bootcamp.scheduler.domain.api;

import com.bootcamp.scheduler.domain.model.Bootcamp;

import java.util.List;
import java.util.Set;

public interface IBootcampServicePort {
    void addBootcamp(Bootcamp bootcamp);
    void associateCapacitiesWithBootcamp(Long bootcampId, Set<Long> capacitiesIds);
    List<Bootcamp> getAllBootcamps(Integer page, Integer size, boolean isAscending, boolean orderByCapCount);
}