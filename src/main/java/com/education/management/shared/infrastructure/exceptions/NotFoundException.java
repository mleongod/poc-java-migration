package com.education.management.shared.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends AppException {

    private NotFoundException(String message) {
        super(message);
    }

    public static NotFoundException create(String message) {
        return new NotFoundException(message);
    }
}
