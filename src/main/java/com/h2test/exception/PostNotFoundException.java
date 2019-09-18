package com.h2test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String exception){
        super(exception);
    }
}
