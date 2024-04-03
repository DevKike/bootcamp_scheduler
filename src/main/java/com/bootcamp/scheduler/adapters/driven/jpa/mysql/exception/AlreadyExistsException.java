package com.bootcamp.scheduler.adapters.driven.jpa.mysql.exception;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
