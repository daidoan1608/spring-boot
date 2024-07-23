package com.vti.blogapp.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class Error {
    private String timestamp;
    private String message;
    private Map<String, String> errors;

    public Error(String message, Map<String, String> errors) {
        this.timestamp = LocalDateTime.now().toString();
        this.message = message;
        this.errors = errors;
    }
}
