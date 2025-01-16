package com.theus.auth_api.user.service.exceptions;

import java.io.Serial;

public class PasswordIncorrectException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public PasswordIncorrectException(String message) {
        super(message);
    }
}
