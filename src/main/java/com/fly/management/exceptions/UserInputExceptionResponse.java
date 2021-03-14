package com.fly.management.exceptions;

public class UserInputExceptionResponse {

    private String message;

    public UserInputExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
