package org.urr.shopbashkortostan.mappers.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.urr.shopbashkortostan.dto.ProductDTO;
import org.urr.shopbashkortostan.enums.Length;
import org.urr.shopbashkortostan.mappers.repository.ProductMapper;
import org.urr.shopbashkortostan.models.Product;

import java.math.BigDecimal;
@Service
@RequiredArgsConstructor
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductDTO toDTO(Product product) {
        if (product == null) return null;

        return new ProductDTO(product.getId(), product.getName(), product.getPrice(),product.getPricePerSquareMeter(), product.getLength(), product.getDensity(),
                product.getThickness(), product.getDescription(), product.getPhoto(), product.isAvailable(), product.getAvailabilityCounter(), product.getWeight());
    }

    @Override
    public Product toEntity(ProductDTO productDTO) {

        return Product.builder().name(productDTO.getName()).price(productDTO.getPrice()).pricePerSquareMeter( productDTO.getPricePerSquareMeter()).length(productDTO.getLength()).density(productDTO.getDensity()).thickness(productDTO.getThickness()).description(productDTO.getDescription()).photo(productDTO.getPhoto()).available(productDTO.isAvailable()).availabilityCounter(productDTO.getAvailabilityCounter()).weight(productDTO.getWeight()).build();
    }
}
