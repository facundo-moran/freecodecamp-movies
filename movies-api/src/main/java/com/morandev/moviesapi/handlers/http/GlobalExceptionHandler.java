package com.morandev.moviesapi.handlers.http;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            ResourceNotFoundException.class,
    })
    @ResponseBody
    public ErrorMessage notFoundRequest(Exception e) {
        return new ErrorMessage(e, HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            BadRequestException.class,
            org.springframework.dao.DuplicateKeyException.class,
            DataIntegrityViolationException.class,
            org.springframework.web.bind.support.WebExchangeBindException.class,
            org.springframework.http.converter.HttpMessageNotReadableException.class,
            org.springframework.web.server.ServerWebInputException.class,
            MethodArgumentTypeMismatchException.class,
            InvalidDataAccessApiUsageException.class,
    })
    @ResponseBody
    public ErrorMessage badRequest(Exception e) {
        return new ErrorMessage(e, HttpStatus.BAD_REQUEST.value());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({
            ConflictException.class
    })
    @ResponseBody
    public ErrorMessage conflict(Exception e) {
        return new ErrorMessage(e, HttpStatus.CONFLICT.value());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({
            ForbiddenException.class
    })
    @ResponseBody
    public ErrorMessage forbidden(Exception e) {
        return new ErrorMessage(e, HttpStatus.FORBIDDEN.value());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({
            Exception.class
    })
    @ResponseBody
    public ErrorMessage exception(Exception e) { // The error type must be corrected
        e.printStackTrace();
        return new ErrorMessage(e, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
