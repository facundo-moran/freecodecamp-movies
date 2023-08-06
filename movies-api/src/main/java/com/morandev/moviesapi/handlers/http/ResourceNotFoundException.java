package com.morandev.moviesapi.handlers.http;

public class ResourceNotFoundException extends RuntimeException {
    private static final String DESCRIPTION = "Not Found Exception";
    public ResourceNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}