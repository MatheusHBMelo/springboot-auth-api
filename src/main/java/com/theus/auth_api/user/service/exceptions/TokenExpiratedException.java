package com.theus.auth_api.user.service.exceptions;

import java.io.Serial;

public class TokenExpiratedException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public TokenExpiratedException(String message) {
        super(message);
    }
}
