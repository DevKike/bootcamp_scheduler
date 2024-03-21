package com.bootcamp.scheduler.domain.util;

public class DomainConstants {
    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    public enum Field {
        NAME,
        DESCRIPTION
    }

    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' can't be null";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' can't be null";

}
