package com.morandev.moviesapi.model;

public class Message {
    private final String message;
    private final boolean error;

    /**
     *  Constructor
     *
     * @param message
     * @param error
     */
    public Message(String message, boolean error) {
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
