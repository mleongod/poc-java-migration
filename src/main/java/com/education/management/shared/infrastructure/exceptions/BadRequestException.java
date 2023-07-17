package com.education.management.shared.infrastructure.exceptions;

public class BadRequestException extends AppException {

    public BadRequestException(String message) {
        super(message);
    }

    public static BadRequestException create(String message) {
        return new BadRequestException(message);
    }
}
