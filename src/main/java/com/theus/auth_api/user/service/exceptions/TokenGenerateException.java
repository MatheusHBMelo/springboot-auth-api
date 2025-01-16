package com.theus.auth_api.user.service.exceptions;

import java.io.Serial;

public class TokenGenerateException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public TokenGenerateException(String message) {
        super(message);
    }
}
