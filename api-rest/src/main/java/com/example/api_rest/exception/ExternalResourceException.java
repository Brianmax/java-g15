package com.example.api_rest.exception;

import javax.management.remote.JMXServerErrorException;

public class ExternalResourceException extends RuntimeException {
    public ExternalResourceException(String message) {
        super(message);
    }
}
