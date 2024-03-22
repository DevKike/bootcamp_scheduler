package com.bootcamp.scheduler.configuration;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.adapter.TechnologyAdapter;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.bootcamp.scheduler.domain.api.ITechnologyServicePort;
import com.bootcamp.scheduler.domain.api.usecase.TechnologyUseCase;
import com.bootcamp.scheduler.domain.spi.ITechnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;

    @Bean
    public ITechnologyPersistencePort technologyPersistencePort() {
        return new TechnologyAdapter(technologyRepository, technologyEntityMapper);
    }

    @Bean
    public ITechnologyServicePort technologyServicePort() {
        return new TechnologyUseCase(technologyPersistencePort());
    }
}