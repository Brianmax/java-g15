package com.example.api_rest.exception;

public class ExternalServiceException extends RuntimeException {
    public ExternalServiceException(String message) {
        super(message);
    }

    public ExternalServiceException(String message, Exception ex) {
        super(message, ex);
    }
}
