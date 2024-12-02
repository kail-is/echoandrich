package com.test.echoandrich.config;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.lang.reflect.InvocationTargetException;

// TODO Custom 필요

@Slf4j
@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleHttpMessageNotReadableException(final HttpMessageNotReadableException ex) {
        preHandle(ex);
        return ErrorResponse.of(ex.getMessage());
    }


    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBindException(final BindException ex) {
        preHandle(ex);
        return ErrorResponse.of(ApiResponseCodes.BAD_REQUEST, ex.getMessage());
    }


    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleEntityNotFoundException(
            final MissingServletRequestParameterException ex) {
        preHandle(ex);
        return ErrorResponse.of(ex);
    }

    @ExceptionHandler(InvocationTargetException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvocationTargetException(
            final MissingServletRequestParameterException ex) {
        preHandle(ex);
        return ErrorResponse.of(ex);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleUnsupportedOperationException(
            final MissingServletRequestParameterException ex) {
        preHandle(ex);
        return ErrorResponse.of(ex);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException ex) {
        preHandle(ex);
        return ErrorResponse.of(ex);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(final ConstraintViolationException ex) {
        preHandle(ex);
        return ErrorResponse.of(ex);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleIllegalArgumentException(final IllegalArgumentException ex) {
        preHandle(ex);
        return ErrorResponse.of(ApiResponseCodes.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleAllException(final Exception ex) {
        preHandle(ex);
        return ErrorResponse.of(ApiResponseCodes.UNKNOWN);
    }

    public void preHandle(final Exception ex) {
        log.error("### message={}, cause={}", ex.getMessage(), ex.getCause(), ex);
    }
}
