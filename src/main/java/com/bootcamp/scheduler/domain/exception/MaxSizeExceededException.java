package com.bootcamp.scheduler.domain.exception;

public class MaxSizeExceededException extends RuntimeException {
    public MaxSizeExceededException(String field, int maxLength) {
        super(String.format("%s cannot exceed %d characters", field, maxLength));
    }
}
