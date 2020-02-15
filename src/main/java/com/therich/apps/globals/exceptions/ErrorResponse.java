package com.therich.apps.globals.exceptions;

import lombok.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created Date 2019.06.23
 * Created By KH.JIN
 *
 * 예외 발생 시 JSON Response Format 클래스
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {

    @Getter
    private List<ErrorItem> errors;

    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public class ErrorItem {
        @Getter
        private String field;
        @Getter
        private String code;
        @Getter
        private String reason;
    }

    protected ErrorResponse(BindingResult result) {
        errors = new ArrayList<>();
        for (FieldError error : result.getFieldErrors()) {
            errors.add(
                ErrorItem
                    .builder()
                    .field(error.getField())
                    .code(error.getCode())
                    .reason(error.getDefaultMessage())
                    .build()
            );
        }
    }
}
