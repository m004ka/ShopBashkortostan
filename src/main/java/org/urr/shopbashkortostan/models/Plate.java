package org.urr.shopbashkortostan.models;
//Карта фибролитовых плит

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Plate {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private BigDecimal price;
    private float priceForMeterSquare;

    private String description;


    public enum Size {
        SIZE_15, SIZE_25,SIZE_35,SIZE_50, SIZE_100
    }

    private Size size;

    private int density;

    private String brand;


    private float height;

    private int inStock;

}
