package com.github.rod1andrade.studyspringboot.services.exceptions;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super(message);
    }
}
