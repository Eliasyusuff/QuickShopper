package com.helpmate.helpmate.exception;

import org.springframework.http.HttpStatus;

public class HelpMateAPIException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public HelpMateAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HelpMateAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}