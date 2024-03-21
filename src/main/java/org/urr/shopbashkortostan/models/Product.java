package org.urr.shopbashkortostan.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.urr.shopbashkortostan.enums.Length;
import org.urr.shopbashkortostan.enums.Thickness;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal pricePerSquareMeter;
    @Enumerated(EnumType.STRING)
    private Length length;
    private int density;
    @Enumerated(EnumType.STRING)
    private Thickness thickness;
    private String description;
    private String photo;
    private boolean available;
    private int availabilityCounter;
    private BigDecimal weight;

    // Геттеры и сеттеры
}

