package com.education.management.shared.infrastructure.exceptions;

public class AppException extends RuntimeException {
    public AppException(String message) {
        super(message);
    }
}
