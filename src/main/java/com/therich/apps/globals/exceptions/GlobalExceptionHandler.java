package com.therich.apps.globals.exceptions;

import com.therich.apps.entrypoints.commons.response.DefaultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(BadRequestException.class)
    protected DefaultResponse<ErrorResponse> handleBadRequestException(BadRequestException e) {
        log.debug("[handle bad request] err response : {}", e.getResult());
        return DefaultResponse
                .<ErrorResponse>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .result(new ErrorResponse(e.getResult()))
                .build();
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Void> handleRuntimeException(Exception e) {
        log.debug("[handle exception] Exception.");
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}