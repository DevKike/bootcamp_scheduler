package com.technologies.microservice.configuration;

import com.technologies.microservice.adapters.driven.jpa.mysql.adapter.TechnologyAdapter;
import com.technologies.microservice.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.technologies.microservice.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.technologies.microservice.domain.api.ITechnologyServicePort;
import com.technologies.microservice.domain.api.usecase.TechnologyUseCase;
import com.technologies.microservice.domain.spi.ITechnologyPersistencePort;
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
