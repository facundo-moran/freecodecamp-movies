package com.morandev.moviesapi.model;

public class RootMessageDto {
    private final String message;
    private final boolean error;

    /**
     *  Constructor
     *
     * @param message
     * @param error
     */
    public RootMessageDto(String message, boolean error) {
        this.message = message;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public boolean isError() {
        return error;
    }
}
