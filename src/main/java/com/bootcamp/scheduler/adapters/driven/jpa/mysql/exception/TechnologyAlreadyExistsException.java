package com.bootcamp.scheduler.adapters.driven.jpa.mysql.exception;

public class TechnologyAlreadyExistsException extends RuntimeException {
    public TechnologyAlreadyExistsException(String message) {
        super(message);
    }
}
