package com.therich.apps.globals.exceptions.handlers;

import com.therich.apps.entrypoints.controllers.DefaultResponse;
import com.therich.apps.globals.ErrorResponse;
import com.therich.apps.globals.exceptions.BadRequestException;
import com.therich.apps.globals.exceptions.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(0)
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(BusinessException.class)
    protected DefaultResponse<Void> handleBusinessException(BusinessException e) {
        log.debug("[handle business] err code : {}", e.getCode());
        return DefaultResponse
                .<Void>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    protected DefaultResponse<ErrorResponse> handleBadRequestException(BadRequestException e) {
        log.debug("[handle bad request] err response : {}", e.getResult());
        return DefaultResponse
                .<ErrorResponse>builder()
                .status(HttpStatus.OK.value())
                .result(new ErrorResponse(e.getResult()))
                .build();
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Void> handleRuntimeException(Exception e) {
        log.debug("[handle exception] Exception. e : {}", e.toString());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}