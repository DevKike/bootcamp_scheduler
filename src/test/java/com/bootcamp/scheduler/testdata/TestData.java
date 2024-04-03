package com.bootcamp.scheduler.testdata;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.exception.TechnologiesNotFoundException;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistsException;
import com.bootcamp.scheduler.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.bootcamp.scheduler.adapters.driving.http.dto.response.TechnologyResponse;
import com.bootcamp.scheduler.domain.exception.EmptyFieldException;
import com.bootcamp.scheduler.domain.exception.MaxSizeExceededException;
import com.bootcamp.scheduler.domain.model.Technology;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static final long TECHNOLOGY_ID = 1L;
    public static final String TECHNOLOGY_NAME = "MySQL";
    public static final String TECHNOLOGY_DESCRIPTION = "Relational database manager";
    public static final Integer PAGE = 0;
    public static final Integer SIZE = 10;
    public static final Sort SORT = Sort.by("name");
    public static final Sort.Direction SORT_ASC = Sort.Direction.ASC;
    public static final Sort.Direction SORT_DESC = Sort.Direction.DESC;

    public static AddTechnologyRequest getValidTechnologyRequestData() {
        return new AddTechnologyRequest(TECHNOLOGY_NAME, TECHNOLOGY_DESCRIPTION);
    }

    public static TechnologyResponse getValidTechnologyResponseData() {
        return new TechnologyResponse(TECHNOLOGY_ID, TECHNOLOGY_NAME, TECHNOLOGY_DESCRIPTION);
    }

    public static Technology getValidTechnologyData() {
        return new Technology(TECHNOLOGY_ID, TECHNOLOGY_NAME, TECHNOLOGY_DESCRIPTION);
    }

    public static Technology getTechnologyWithEmptyName() {
        return new Technology(TECHNOLOGY_ID, "", TECHNOLOGY_DESCRIPTION);
    }

    public static Technology getTechnologyWithEmptyDescription() {
        return new Technology(TECHNOLOGY_ID, TECHNOLOGY_NAME, "");
    }

    public static Technology getTechnologyWithNameExceedingAllowedSize() {
        String longName = "Lorem ipsum dolor sit amet consectetur disciplining elit.";
        return new Technology(TECHNOLOGY_ID, longName, TECHNOLOGY_DESCRIPTION);
    }

    public static Technology getTechnologyWithDescriptionExceedingAllowedSize() {
        String longDescription = "Lorem ipsum dolor sit amet consectetur adipiscing elit curabitur, conubia congue elementum.";
        return new Technology(TECHNOLOGY_ID, TECHNOLOGY_NAME, longDescription);
    }

    public static EmptyFieldException getEmptyFieldException() {
        return new EmptyFieldException("emptyField");
    }

    public static MaxSizeExceededException getMaxSizeExceededException() {
        return new MaxSizeExceededException("Max size exceeded for the request");
    }

    public static TechnologyAlreadyExistsException getTechnologyAlreadyExistsException() {
        return new TechnologyAlreadyExistsException("Technology already exists in the database");
    }

    public static TechnologiesNotFoundException getTechnologiesNotFoundException() {
        return new TechnologiesNotFoundException("No registered technologies found");
    }

    public static List<TechnologyEntity> getTechnologyEntities() {
        List<TechnologyEntity> technologyEntities = new ArrayList<>();
        technologyEntities.add(new TechnologyEntity(TECHNOLOGY_ID, TECHNOLOGY_NAME, TECHNOLOGY_DESCRIPTION));
        technologyEntities.add(new TechnologyEntity(TECHNOLOGY_ID, TECHNOLOGY_NAME, TECHNOLOGY_DESCRIPTION));
        return technologyEntities;
    }

    public static List<Technology> getExpectedTechnologies() {
        List<Technology> expectedTechnologies = new ArrayList<>();
        expectedTechnologies.add(new Technology(TECHNOLOGY_ID, TECHNOLOGY_NAME, TECHNOLOGY_DESCRIPTION));
        expectedTechnologies.add(new Technology(TECHNOLOGY_ID, TECHNOLOGY_NAME, TECHNOLOGY_DESCRIPTION));
        return expectedTechnologies;
    }

    public static List<TechnologyResponse> getTechnologyResponses() {
        List<TechnologyResponse> technologyResponses = new ArrayList<>();
        technologyResponses.add(new TechnologyResponse(TECHNOLOGY_ID, TECHNOLOGY_NAME, TECHNOLOGY_DESCRIPTION));
        technologyResponses.add(new TechnologyResponse(TECHNOLOGY_ID, TECHNOLOGY_NAME, TECHNOLOGY_DESCRIPTION));
        return technologyResponses;
    }
}