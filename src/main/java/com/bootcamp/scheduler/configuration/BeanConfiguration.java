package com.bootcamp.scheduler.configuration;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.adapter.CapacityAdapter;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.adapter.TechnologyAdapter;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.mapper.ICapacityEntityMapper;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.bootcamp.scheduler.domain.api.ICapacityServicePort;
import com.bootcamp.scheduler.domain.api.ITechnologyServicePort;
import com.bootcamp.scheduler.domain.api.usecase.CapacityUseCase;
import com.bootcamp.scheduler.domain.api.usecase.TechnologyUseCase;
import com.bootcamp.scheduler.domain.spi.ICapacityPersistencePort;
import com.bootcamp.scheduler.domain.spi.ITechnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;
    private final ICapacityRepository capacityRepository;
    private final ICapacityEntityMapper capacityEntityMapper;

    @Bean
    public ITechnologyPersistencePort technologyPersistencePort() {
        return new TechnologyAdapter(technologyRepository, technologyEntityMapper);
    }

    @Bean
    public ITechnologyServicePort technologyServicePort() {
        return new TechnologyUseCase(technologyPersistencePort());
    }

    @Bean
    public ICapacityPersistencePort capacityPersistencePort() {
        return new CapacityAdapter(capacityRepository, technologyRepository, capacityEntityMapper);
    }

    @Bean
    public ICapacityServicePort capacityServicePort() {
        return new CapacityUseCase(capacityPersistencePort());
    }
}