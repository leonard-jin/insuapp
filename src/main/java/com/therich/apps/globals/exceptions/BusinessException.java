package com.therich.apps.globals.exceptions;

import com.therich.apps.globals.exceptions.codes.BusinessErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by kh.jin on 2020. 1. 19.
 * Business 흐름에서 발생하는 예외에 대한 처리를 담당한다.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends AppsException {
    private BusinessErrorCode code;
    private String message;

    public BusinessException(BusinessErrorCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public BusinessException(BusinessErrorCode code) {
        this.code = code;
        this.message = "";
    }
}
