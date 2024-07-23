package com.vti.blogapp.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers, HttpStatusCode status, WebRequest request
    ) {
        var message = "Sorry, invalid form";
        var errors = new LinkedHashMap<String, String>();
        for (var error : exception.getFieldErrors()) { // Corrected this line
            var key = error.getField();
            var value = error.getDefaultMessage();
            errors.put(key, value);
        }
        var response = new Error(message, errors);
        return new ResponseEntity<>(response, headers, status);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstrainViolation(
            ConstraintViolationException exception
    ) {
        var message = "Sorry, invalid form";
        var errors = new LinkedHashMap<String, String>();
        for (var constrain : exception.getConstraintViolations()) {
            var key = constrain.getPropertyPath().toString();
            var value = constrain.getMessage();
            errors.put(key, value);
        }
        var response = new Error(message, errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST );
    }
}
