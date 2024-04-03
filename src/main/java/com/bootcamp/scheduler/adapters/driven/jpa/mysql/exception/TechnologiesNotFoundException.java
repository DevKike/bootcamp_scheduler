package com.bootcamp.scheduler.adapters.driven.jpa.mysql.exception;

public class TechnologiesNotFoundException extends RuntimeException {
    public TechnologiesNotFoundException(String message) {
        super(message);
    }
}