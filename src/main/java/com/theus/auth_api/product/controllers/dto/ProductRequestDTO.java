package com.theus.auth_api.product.controllers.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequestDTO(@NotBlank String name, @NotBlank String description, @NotNull BigDecimal price) {
}
