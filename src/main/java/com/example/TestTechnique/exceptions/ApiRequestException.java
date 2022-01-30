package com.example.TestTechnique.exceptions;

public class ApiRequestException extends RuntimeException {
    
    public ApiRequestException (String message) {
        super(message);
    }
}
