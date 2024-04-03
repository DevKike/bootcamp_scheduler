package com.bootcamp.scheduler.adapters.driven.jpa.mysql.exception;

public class NoTechnologiesFoundException extends RuntimeException {
    public NoTechnologiesFoundException(String message) {
        super(message);
    }
}