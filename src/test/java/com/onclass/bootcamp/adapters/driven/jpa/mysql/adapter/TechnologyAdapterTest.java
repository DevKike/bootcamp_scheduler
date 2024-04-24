package com.onclass.bootcamp.adapters.driven.jpa.mysql.adapter;

import com.onclass.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.exception.AlreadyExistsException;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.exception.NotFoundException;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.onclass.bootcamp.domain.model.Technology;
import com.onclass.bootcamp.testdata.TestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void itShouldThrowExceptionWhenSavingDuplicateTechnologySuccessfully() {
        Technology technology = TestData.getValidTechnologyData();
        when(technologyRepository.findByName(technology.getName())).thenReturn(Optional.of(new TechnologyEntity()));

        assertThrows(AlreadyExistsException.class, () -> technologyAdapter.addTechnology(technology));

        verify(technologyRepository, times(1)).findByName(technology.getName());

        verify(technologyRepository, never()).save(any());
    }

    @Test
    void itShouldGetAllTechnologiesSuccessfully() {
        List<TechnologyEntity> technologyEntities = TestData.getTechnologyEntities();
        List<Technology> expectedTechnologies = TestData.getExpectedTechnologies();

        when(technologyRepository.findAll(any(Pageable.class)))
                .thenReturn(new PageImpl<>(technologyEntities));

        when(technologyEntityMapper.toModelList(technologyEntities))
                .thenReturn(expectedTechnologies);

        TechnologyAdapter technologyAdapter = new TechnologyAdapter(technologyRepository, technologyEntityMapper);

        List<Technology> actualTechnologies = technologyAdapter.getAllTechnologies(TestData.PAGE, TestData.SIZE, TestData.SORT);

        verify(technologyRepository, times(1)).findAll(any(Pageable.class));

        assertEquals(expectedTechnologies, actualTechnologies);
    }

    @Test
    void itShouldThrowAnExceptionWhenNoRegisteredTechnologiesFoundSuccessfully() {
        when(technologyRepository.findAll(any(Pageable.class)))
                .thenReturn(new PageImpl<>(List.of()));

        assertThrows(NotFoundException.class, () -> technologyAdapter.getAllTechnologies(TestData.PAGE, TestData.SIZE, TestData.SORT));

        verify(technologyRepository, times(1)).findAll(any(Pageable.class));
    }
}