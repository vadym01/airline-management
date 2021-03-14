package com.fly.management.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserWrongInputException extends RuntimeException{

    public UserWrongInputException(String message) {
        super(message);
    }
}
