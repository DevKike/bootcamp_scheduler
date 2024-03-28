package com.bootcamp.scheduler.adapters.driven.jpa.mysql.adapter;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistsException;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.bootcamp.scheduler.domain.model.Technology;
import com.bootcamp.scheduler.testdata.TestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TechnologyAdapterTest {
    @Mock
    private ITechnologyRepository technologyRepository;

    @Mock
    private ITechnologyEntityMapper technologyEntityMapper;

    @InjectMocks
    private TechnologyAdapter technologyAdapter;

    @Test
    void itShouldSaveATechnologyToTheDatabaseSuccessfully() {
        Technology technology = TestData.getValidTechnologyData();
        when(technologyRepository.findByName(technology.getName())).thenReturn(java.util.Optional.empty());

        technologyAdapter.addTechnology(technology);

        verify(technologyRepository, times(1)).save(any());
    }

    @Test
    void itShouldThrowExceptionWhenSavingDuplicateTechnology() {
        Technology technology = TestData.getValidTechnologyData();
        when(technologyRepository.findByName(technology.getName())).thenReturn(Optional.of(new TechnologyEntity()));

        assertThrows(TechnologyAlreadyExistsException.class, () -> {
            technologyAdapter.addTechnology(technology);
        });

        verify(technologyRepository, times(1)).findByName(technology.getName());

        verify(technologyRepository, never()).save(any());
    }
}