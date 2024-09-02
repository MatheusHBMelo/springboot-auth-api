package com.theus.auth_api.product.mapper;

import com.theus.auth_api.product.dto.ProductRequestDTO;
import com.theus.auth_api.product.dto.ProductResponseDTO;
import com.theus.auth_api.product.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    List<ProductResponseDTO> toListOfProductResponseDTO(List<Product> products);

    @Mapping(target = "id", ignore = true)
    Product toProduct(ProductRequestDTO productRequestDTO);
}
