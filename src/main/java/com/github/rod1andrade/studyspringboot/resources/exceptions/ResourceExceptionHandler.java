package com.github.rod1andrade.studyspringboot.resources.exceptions;

import com.github.rod1andrade.studyspringboot.services.exceptions.DatabaseException;
import com.github.rod1andrade.studyspringboot.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest req) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        return ResponseEntity
                .status(status)
                .body(new StandardError(
                        Instant.now(),
                        status.value(),
                        "Not Found",
                        e.getMessage(),
                        req.getRequestURI()
                ));
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseException(DatabaseException e, HttpServletRequest req) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        return ResponseEntity
                .status(status)
                .body(new StandardError(
                        Instant.now(),
                        status.value(),
                        "Database error",
                        e.getMessage(),
                        req.getRequestURI()
                ));
    }
}
