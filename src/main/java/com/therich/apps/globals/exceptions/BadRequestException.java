package com.therich.apps.globals.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.validation.BindingResult;

/**
 * Created by kh.jin on 2019. 6. 22.
 * Request 정보에서 유효하지 않는 값에 대한 예외처리
 */
@EqualsAndHashCode(callSuper = false)
@ToString
public class BadRequestException extends AppsException {
    @Getter
    private BindingResult result;

    public BadRequestException(BindingResult result) {
        this.result = result;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
