package com.heroku.insuapp.globals.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Void> handleRuntimeException(Exception e) {
        log.debug("[exception handle] Exception.");
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}