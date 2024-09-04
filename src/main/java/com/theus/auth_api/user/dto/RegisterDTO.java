package com.theus.auth_api.user.dto;

import com.theus.auth_api.user.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(@NotBlank String username, @NotBlank String password, @NotNull UserRole role) {
}
