package com.morandev.moviesapi.handlers.http;

public class ConflictException extends RuntimeException {
    private static final String DESCRIPTION = "Conflict Exception";
    public ConflictException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
