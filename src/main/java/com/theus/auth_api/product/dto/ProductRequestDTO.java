package com.theus.auth_api.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequestDTO(@NotBlank String name, @NotNull Double price, @NotBlank String description) {
}
