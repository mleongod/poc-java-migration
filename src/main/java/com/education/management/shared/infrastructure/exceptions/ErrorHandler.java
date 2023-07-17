package com.education.management.shared.infrastructure.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Data
@AllArgsConstructor
class ErrorMessageFormat {
    private Integer status;
    private Date timestamp;
    private String message;
    private List<String> details;
    private String context;
}

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> fieldErrors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> fieldErrors.add("field: " + error.getField() + ". Reason:  " + error.getDefaultMessage()));
        String message = "Validation errors";
        ErrorMessageFormat messageModel = new ErrorMessageFormat(status.value(), new Date(), message, fieldErrors, null);
        return new ResponseEntity<>(messageModel, status);
    }

    @ExceptionHandler(value = {AppException.class})
    public ResponseEntity<ErrorMessageFormat> handleNotFoundException(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (ex instanceof NotFoundException) {
            status = HttpStatus.NOT_FOUND;
        }
        if (ex instanceof BadRequestException) {
            status = HttpStatus.BAD_REQUEST;
        }
        ErrorMessageFormat messageModel = new ErrorMessageFormat(status.value(), new Date(), ex.getMessage(), null, ex.getClass().getSimpleName());
        return new ResponseEntity<>(messageModel, status);
    }
}
