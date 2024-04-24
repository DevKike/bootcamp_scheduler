package com.onclass.bootcamp.domain.model;

import com.onclass.bootcamp.domain.exception.EmptyFieldException;
import com.onclass.bootcamp.domain.exception.SizeException;
import com.onclass.bootcamp.testdata.TestData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertThrows(SizeException.class, TestData::getTechnologyWithNameExceedingAllowedSize);
    }

    @Test
    void itShouldThrowAnExceptionWhenDescriptionExceedsAllowedSize() {
        assertThrows(SizeException.class, TestData::getTechnologyWithDescriptionExceedingAllowedSize);
    }
}