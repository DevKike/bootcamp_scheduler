package com.bootcamp.scheduler.domain.api.usecase;

import com.bootcamp.scheduler.domain.model.Technology;
import com.bootcamp.scheduler.domain.spi.ITechnologyPersistencePort;
import com.bootcamp.scheduler.testdata.TestData;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TechnologyUseCaseTest {
    @Mock
    private ITechnologyPersistencePort technologyPersistencePort;

    @InjectMocks
    private TechnologyUseCase technologyUseCase;

    @Test
    void itShouldSaveATechnologySuccessfully() {
        Technology technology = TestData.getValidTechnologyData();

        technologyUseCase.addTechnology(technology);

        verify(technologyPersistencePort, times(1)).addTechnology(technology);
    }

    @Test
    void itShouldGetAllTechnologiesWithPaginationAndSorting() {
        List<Technology> expectedTechnologies = TestData.getExpectedTechnologies();

        when(technologyPersistencePort.getAllTechnologies(TestData.PAGE, TestData.SIZE, TestData.SORT))
                .thenReturn(expectedTechnologies);

        List<Technology> actualTechnologies = technologyUseCase.getAllTechnologies(TestData.PAGE, TestData.SIZE, TestData.SORT_ASC);

        verify(technologyPersistencePort, times(1)).getAllTechnologies(TestData.PAGE, TestData.SIZE, TestData.SORT);

        assertEquals(expectedTechnologies, actualTechnologies);
    }
}