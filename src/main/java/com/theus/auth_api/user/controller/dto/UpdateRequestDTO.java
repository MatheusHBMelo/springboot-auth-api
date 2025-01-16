package com.theus.auth_api.user.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateRequestDTO(
        @NotBlank String currentUsername,
        @NotBlank String currentPassword,
        String newUsername,
        String newPassword
) {}
