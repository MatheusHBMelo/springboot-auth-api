package com.theus.auth_api.product.service;

import com.theus.auth_api.product.dto.ProductRequestDTO;
import com.theus.auth_api.product.dto.ProductResponseDTO;
import com.theus.auth_api.product.mapper.ProductMapper;
import com.theus.auth_api.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponseDTO> getProducts() {
        return ProductMapper.INSTANCE.toListOfProductResponseDTO(productRepository.findAll());
    }

    public void saveProduct(ProductRequestDTO productRequestDTO) {
        this.productRepository.save(ProductMapper.INSTANCE.toProduct(productRequestDTO));
    }
}
