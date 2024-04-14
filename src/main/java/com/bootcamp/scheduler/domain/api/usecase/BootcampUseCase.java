package com.bootcamp.scheduler.domain.api.usecase;

import com.bootcamp.scheduler.domain.api.IBootcampServicePort;
import com.bootcamp.scheduler.domain.model.Bootcamp;
import com.bootcamp.scheduler.domain.spi.IBootcampPersistencePort;

import java.util.Set;

public class BootcampUseCase implements IBootcampServicePort {
    private final IBootcampPersistencePort bootcampPersistencePort;

    public BootcampUseCase(IBootcampPersistencePort bootcampPersistencePort) {
        this.bootcampPersistencePort = bootcampPersistencePort;
    }

    @Override
    public void addBootcamp(Bootcamp bootcamp) {
        bootcampPersistencePort.addBootcamp(bootcamp);
    }

    @Override
    public void associateCapacitiesWithBootcamp(Long bootcampId, Set<Long> capacitiesIds) {
        bootcampPersistencePort.associateCapacitiesWithBootcamp(bootcampId, capacitiesIds);
    }
}