package com.h2test.exception;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String exception){
        super(exception);
    }
}
