package com.github.rod1andrade.studyspringboot.resources.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Resource not found: id: " + id);
    }
}
