package com.morandev.moviesapi.handler.http;

public class ConflictException extends RuntimeException {
    private static final String DESCRIPTION = "Conflict Exception";
    public ConflictException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
