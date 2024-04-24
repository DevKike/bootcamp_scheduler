package com.onclass.bootcamp.adapters.driving.http.controller;

import com.onclass.bootcamp.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.onclass.bootcamp.adapters.driving.http.dto.response.TechnologyResponse;
import com.onclass.bootcamp.adapters.driving.http.mapper.ITechnologyRequestMapper;
import com.onclass.bootcamp.adapters.driving.http.mapper.ITechnologyResponseMapper;
import com.onclass.bootcamp.domain.api.ITechnologyServicePort;
import com.onclass.bootcamp.domain.model.Technology;
import com.onclass.bootcamp.testdata.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TechnologyRestControllerAdapterTest {

    @Mock
    private ITechnologyServicePort technologyServicePort;

    @Mock
    private ITechnologyRequestMapper technologyRequestMapper;

    @Mock
    private ITechnologyResponseMapper technologyResponseMapper;

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

    @Test
    void itShouldGetAllTechnologiesInAscendingOrder() {
        List<Technology> technologies = TestData.getExpectedTechnologies();
        List<TechnologyResponse> expectedResponses = TestData.getTechnologyResponses();

        when(technologyServicePort.getAllTechnologies(TestData.PAGE, TestData.SIZE, TestData.SORT_ASC))
                .thenReturn(technologies);

        when(technologyResponseMapper.toTechnologyResponseList(technologies))
                .thenReturn(expectedResponses);

        ResponseEntity<List<TechnologyResponse>> responseEntity = technologyRestControllerAdapter.getAllTechnologies(TestData.PAGE, TestData.SIZE, TestData.SORT_ASC);

        verify(technologyServicePort, times(1)).getAllTechnologies(TestData.PAGE, TestData.SIZE, TestData.SORT_ASC);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponses, responseEntity.getBody());
    }

    @Test
    void itShouldGetAllTechnologiesInDescendingOrder() {
        List<Technology> technologies = TestData.getExpectedTechnologies();
        List<TechnologyResponse> expectedResponses = TestData.getTechnologyResponses();

        when(technologyServicePort.getAllTechnologies(TestData.PAGE, TestData.SIZE, TestData.SORT_DESC))
                .thenReturn(technologies);

        when(technologyResponseMapper.toTechnologyResponseList(technologies))
                .thenReturn(expectedResponses);

        ResponseEntity<List<TechnologyResponse>> responseEntity = technologyRestControllerAdapter.getAllTechnologies(TestData.PAGE, TestData.SIZE, TestData.SORT_DESC);

        verify(technologyServicePort, times(1)).getAllTechnologies(TestData.PAGE, TestData.SIZE, TestData.SORT_DESC);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponses, responseEntity.getBody());
    }
}