package com.bootcamp.scheduler.domain.model;

import com.bootcamp.scheduler.domain.exception.EmptyFieldException;
import com.bootcamp.scheduler.domain.exception.MaxSizeExceededException;
import com.bootcamp.scheduler.testdata.TestData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TechnologyTest {

    @Test
    void itShouldThrowAExceptionWhenNameIsEmpty() {
        assertThrows(EmptyFieldException.class, TestData::getTechnologyWithEmptyName);
    }

    @Test
    void itShouldThrowAExceptionWhenDescriptionIsEmpty() {
        assertThrows(EmptyFieldException.class, TestData::getTechnologyWithEmptyDescription);
    }

    @Test
    void itShouldThrowAnExceptionWhenNameExceedsAllowedSize() {
        assertThrows(MaxSizeExceededException.class, TestData::getTechnologyWithNameExceedingAllowedSize);
    }

    @Test
    void itShouldThrowAnExceptionWhenDescriptionExceedsAllowedSize() {
        assertThrows(MaxSizeExceededException.class, TestData::getTechnologyWithDescriptionExceedingAllowedSize);
    }
}