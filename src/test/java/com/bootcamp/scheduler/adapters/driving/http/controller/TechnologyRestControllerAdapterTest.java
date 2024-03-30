package com.bootcamp.scheduler.adapters.driving.http.controller;

import com.bootcamp.scheduler.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.bootcamp.scheduler.adapters.driving.http.mapper.ITechnologyRequestMapper;
import com.bootcamp.scheduler.domain.api.ITechnologyServicePort;
import com.bootcamp.scheduler.testdata.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TechnologyRestControllerAdapterTest {

    @Mock
    private ITechnologyServicePort technologyServicePort;

    @Mock
    private ITechnologyRequestMapper technologyRequestMapper;

    @InjectMocks
    private TechnologyRestControllerAdapter technologyRestControllerAdapter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void itShouldAddTechnologyValidRequestAndReturnCreatedResponse() {
        AddTechnologyRequest request = TestData.getValidTechnologyRequestData();

        when(technologyRequestMapper.addRequestToTechnology(request)).thenReturn(any());

        ResponseEntity<Void> responseEntity = technologyRestControllerAdapter.addTechnology(request);

        verify(technologyRequestMapper).addRequestToTechnology(request);
        verify(technologyServicePort).addTechnology(any());
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }
}