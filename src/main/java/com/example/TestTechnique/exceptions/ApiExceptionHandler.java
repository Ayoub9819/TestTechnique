package com.example.TestTechnique.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
   // exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(
           e.getMessage (),
            badRequest,
            ZonedDateTime.now(ZoneId.of("Z"))
    );

    return new ResponseEntity<>(apiException, badRequest);
}

@ExceptionHandler(value = {ApiServerException.class})
    public ResponseEntity<Object> handleApiServerException(ApiServerException e) {
   // exception details
        HttpStatus serverError = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiException apiException = new ApiException(
           e.getMessage (),
           serverError,
            ZonedDateTime.now(ZoneId.of("Z"))
    );

    return new ResponseEntity<>(apiException, serverError);
}
}
