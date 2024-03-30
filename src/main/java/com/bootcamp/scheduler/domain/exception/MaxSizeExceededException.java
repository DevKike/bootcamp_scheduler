package com.bootcamp.scheduler.domain.exception;

public class MaxSizeExceededException extends RuntimeException {
    public MaxSizeExceededException(String message) {
        super(message);
    }
}