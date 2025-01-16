package com.theus.auth_api.user.service.exceptions;

import java.io.Serial;

public class UsernameIncorrectException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public UsernameIncorrectException(String message) {
        super(message);
    }
}
