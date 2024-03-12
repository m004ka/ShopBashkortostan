package org.urr.shopbashkortostan.mappers.repository;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import org.urr.shopbashkortostan.dto.ProductDTO;
import org.urr.shopbashkortostan.models.Product;


public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);
}