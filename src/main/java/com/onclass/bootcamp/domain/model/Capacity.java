package com.onclass.bootcamp.domain.model;

import com.onclass.bootcamp.domain.exception.EmptyFieldException;
import com.onclass.bootcamp.domain.exception.SizeException;
import com.onclass.bootcamp.domain.util.DomainConstants;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class Capacity {
    private Long id;
    private String name;
    private String description;
    private List<Technology> technologies;

    public Capacity(Long id, String name, String description, List<Technology> technologies) {
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
        this.technologies = technologies;
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

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }
}