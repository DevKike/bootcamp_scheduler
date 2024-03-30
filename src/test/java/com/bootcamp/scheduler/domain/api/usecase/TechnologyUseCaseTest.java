package com.bootcamp.scheduler.domain.api.usecase;

import com.bootcamp.scheduler.domain.model.Technology;
import com.bootcamp.scheduler.domain.spi.ITechnologyPersistencePort;
import com.bootcamp.scheduler.testdata.TestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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
}