package com.theus.auth_api.product.controllers;

import com.theus.auth_api.product.dto.ProductRequestDTO;
import com.theus.auth_api.product.dto.ProductResponseDTO;
import com.theus.auth_api.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<Void> saveProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO) {
        this.productService.saveProduct(productRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
