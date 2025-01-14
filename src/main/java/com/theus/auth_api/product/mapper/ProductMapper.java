package com.theus.auth_api.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import org.mapstruct.NullValuePropertyMappingStrategy;

import com.theus.auth_api.product.controllers.dto.ProductRequestDTO;
import com.theus.auth_api.product.model.Product;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    void updateProductFromDto(ProductRequestDTO productDTO, @MappingTarget Product product);
}
