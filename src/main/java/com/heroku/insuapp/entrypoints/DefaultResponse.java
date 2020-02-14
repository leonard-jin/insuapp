package com.heroku.insuapp.entrypoints;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Created by kh.jin on 2020. 2. 13.
 */

@EqualsAndHashCode(callSuper = false)
@ToString
public class DefaultResponse<T> {
    private final static int DEFAULT_CODE = 0;
    private final static HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.OK;
    private final static String DEFAULT_MESSAGE = "SUCCESS.";

    private int code;
    private int status;
    private String message;
    private LocalDateTime timestamp;
    private T result;

    public DefaultResponse(int code, int status, String message, T result) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.result = result;
        this.timestamp = LocalDateTime.now();
    }

    public static <T> DefaultResponse success(T result) {
        return new DefaultResponse(DEFAULT_CODE, DEFAULT_HTTP_STATUS.value(), DEFAULT_MESSAGE, result);
    }
}
