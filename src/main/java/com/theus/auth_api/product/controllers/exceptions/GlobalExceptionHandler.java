package com.theus.auth_api.product.controllers.exceptions;

import com.theus.auth_api.product.service.exceptions.DatabaseException;
import com.theus.auth_api.product.service.exceptions.ObjectNotFoundException;
import com.theus.auth_api.user.service.exceptions.PasswordIncorrectException;
import com.theus.auth_api.user.service.exceptions.TokenGenerateException;
import com.theus.auth_api.user.service.exceptions.UsernameIncorrectException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(Instant.now(), status.value(), "Object not found", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseException(DatabaseException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(Instant.now(), status.value(), "Database error", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(PasswordIncorrectException.class)
    public ResponseEntity<StandardError> passwordIncorrectException(PasswordIncorrectException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        StandardError error = new StandardError(Instant.now(), status.value(), "Password Incorrect", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(UsernameIncorrectException.class)
    public ResponseEntity<StandardError> usernameIncorrectException(UsernameIncorrectException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        StandardError error = new StandardError(Instant.now(), status.value(), "Username Incorrect", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(TokenGenerateException.class)
    public ResponseEntity<StandardError> usernameIncorrectException(TokenGenerateException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(Instant.now(), status.value(), "Error generating token", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
