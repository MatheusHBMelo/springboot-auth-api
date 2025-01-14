package com.theus.auth_api.product.service;

import com.theus.auth_api.product.controllers.dto.ProductRequestDTO;
import com.theus.auth_api.product.controllers.dto.ProductResponseDTO;
import com.theus.auth_api.product.mapper.ProductMapper;
import com.theus.auth_api.product.model.Product;
import com.theus.auth_api.product.repositories.ProductRepository;
import com.theus.auth_api.product.service.exceptions.DatabaseException;
import com.theus.auth_api.product.service.exceptions.ObjectNotFoundException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponseDTO findById(Long id) {
        return productRepository.findById(id)
                .map(ProductResponseDTO::new)
                .orElseThrow(() -> new ObjectNotFoundException("Product with id {" + id + "} not found!"));
    }

    public List<ProductResponseDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void create(ProductRequestDTO productRequestDto) {
        productRepository.save(new Product(productRequestDto));
    }

    @Transactional
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ObjectNotFoundException("Product with id {" + id + "} not found!");
        }
        try {
            productRepository.deleteById(id);
        } catch (RuntimeException ex) {
            throw new DatabaseException("Error deleting product with id {" + id + "} - " + ex.getMessage());
        }
    }

    @Transactional
    public ProductResponseDTO update(Long id, ProductRequestDTO productRequestDTO) {
        Optional<Product> productDb = productRepository.findById(id);
        if (productDb.isEmpty()) {
            throw new ObjectNotFoundException("Product with id {" + id + "} not found!");
        }
        Product product = productDb.get();
        ProductMapper.INSTANCE.updateProductFromDto(productRequestDTO, product);
        return new ProductResponseDTO(productRepository.save(product));
    }
}
