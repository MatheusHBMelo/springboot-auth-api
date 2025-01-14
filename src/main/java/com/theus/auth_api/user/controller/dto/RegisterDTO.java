package com.theus.auth_api.user.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(@NotBlank String username, @NotBlank String password) {
}
