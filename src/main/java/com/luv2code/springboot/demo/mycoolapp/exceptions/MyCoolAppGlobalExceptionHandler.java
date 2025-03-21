package com.luv2code.springboot.demo.mycoolapp.exceptions;

import com.luv2code.springboot.demo.mycoolapp.models.MyCoolAppErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Best practice for large scale projects or real time projects to handle any exceptions globally.
@ControllerAdvice
public class MyCoolAppGlobalExceptionHandler {
    // Add an exception handler using @ExceptionHandler.
    @ExceptionHandler
    public ResponseEntity<MyCoolAppErrorResponse> handleException(StudentNotFoundException ex) {
        return new ResponseEntity<>(new MyCoolAppErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis()), HttpStatus.NOT_FOUND);
    }

    // Add another exception handler to catch any exception (catch all).
    @ExceptionHandler
    public ResponseEntity<MyCoolAppErrorResponse> handleAllException(Exception ex) {
        return new ResponseEntity<>(new MyCoolAppErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }
}
