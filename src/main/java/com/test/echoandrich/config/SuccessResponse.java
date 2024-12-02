package com.test.echoandrich.config;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.slf4j.MDC;

import java.time.LocalDateTime;

public class SuccessResponse<T> extends ApiResponse {
    private String message;
    private T data;

    public SuccessResponse(String message, T data) {
        super("200", message);
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static <T> SuccessResponse<T> of(String message, T data) {
        return new SuccessResponse<>(message, data);
    }

    public static <T> SuccessResponse<String> of(String message) {
        return new SuccessResponse<>(message, message);
    }
}

