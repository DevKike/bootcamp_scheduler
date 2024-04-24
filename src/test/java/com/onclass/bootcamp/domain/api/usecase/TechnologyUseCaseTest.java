package com.onclass.bootcamp.domain.api.usecase;

import com.onclass.bootcamp.domain.model.Technology;
import com.onclass.bootcamp.domain.spi.ITechnologyPersistencePort;
import com.onclass.bootcamp.testdata.TestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


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