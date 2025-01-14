package com.theus.auth_api.product.controllers.dto;

import java.math.BigDecimal;

import com.theus.auth_api.product.model.Product;

public record ProductResponseDTO(Long id, String name, String description, BigDecimal price) {
    public ProductResponseDTO(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
}
