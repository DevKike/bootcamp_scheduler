package com.bootcamp.scheduler.domain.api.usecase;

import com.bootcamp.scheduler.domain.api.IBootcampServicePort;
import com.bootcamp.scheduler.domain.model.Bootcamp;
import com.bootcamp.scheduler.domain.spi.IBootcampPersistencePort;

public class BootcampUseCase implements IBootcampServicePort {
    private final IBootcampPersistencePort bootcampPersistencePort;

    public BootcampUseCase(IBootcampPersistencePort bootcampPersistencePort) {
        this.bootcampPersistencePort = bootcampPersistencePort;
    }

    @Override
    public void addBootcamp(Bootcamp bootcamp) {
        bootcampPersistencePort.addBootcamp(bootcamp);
    }
}