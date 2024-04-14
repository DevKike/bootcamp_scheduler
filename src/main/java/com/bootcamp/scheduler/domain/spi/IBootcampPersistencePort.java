package com.bootcamp.scheduler.domain.spi;

import com.bootcamp.scheduler.domain.model.Bootcamp;

public interface IBootcampPersistencePort {
    void addBootcamp(Bootcamp bootcamp);
}
