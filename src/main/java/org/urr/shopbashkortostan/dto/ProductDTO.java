package org.urr.shopbashkortostan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.urr.shopbashkortostan.enums.Length;
import org.urr.shopbashkortostan.enums.Thickness;


import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal pricePerSquareMeter;
    private Length length;
    private int density;
    private Thickness thickness;
    private String description;
    private String photo;
    private boolean available;
    private int availabilityCounter;
    private BigDecimal weight;
}