package com.bootcamp.scheduler.domain.api;

import com.bootcamp.scheduler.domain.model.Bootcamp;

public interface IBootcampServicePort {
    void addBootcamp(Bootcamp bootcamp);
}