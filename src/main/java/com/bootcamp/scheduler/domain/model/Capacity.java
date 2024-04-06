package com.bootcamp.scheduler.domain.model;

import com.bootcamp.scheduler.domain.exception.EmptyFieldException;
import com.bootcamp.scheduler.domain.exception.SizeException;
import com.bootcamp.scheduler.domain.util.DomainConstants;

import static java.util.Objects.requireNonNull;

public class Capacity {
    private final Long id;
    private final String name;
    private String description;

    public Capacity(Long id, String name, String description) {
        if (name == null || name.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        if (name.length() > 50) {
            throw new SizeException(String.format("%s cannot exceed %d characters", DomainConstants.Field.NAME, DomainConstants.MAX_NAME_LENGTH));
        }
        if (description == null || description.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.DESCRIPTION.toString());
        }
        if (description.length() > 90) {
            throw new SizeException(String.format("%s cannot exceed %d characters", DomainConstants.Field.DESCRIPTION, DomainConstants.MAX_DESCRIPTION_LENGTH));
        }

        this.id = id;
        this.name = requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}