package com.bootcamp.scheduler.testdata;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistsException;
import com.bootcamp.scheduler.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.bootcamp.scheduler.adapters.driving.http.dto.response.TechnologyResponse;
import com.bootcamp.scheduler.domain.exception.EmptyFieldException;
import com.bootcamp.scheduler.domain.exception.MaxSizeExceededException;
import com.bootcamp.scheduler.domain.model.Technology;

public class TestData {

    public static final long TECHNOLOGY_ID = 1L;
    public static final String TECHNOLOGY_NAME = "MySQL";
    public static final String TECHNOLOGY_DESCRIPTION = "Relational database manager";

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
}
