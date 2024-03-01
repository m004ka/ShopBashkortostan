package org.urr.shopbashkortostan.models;
//Карта фибролитовых плит

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class CartStove {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private BigDecimal price;
    private float priceForMeterSquare;

    private String Text;

    private enum Size {
        SIZE_15, SIZE_25,SIZE_35,SIZE_50, SIZE_100
    }
    private int density;
    private String mark;

    private float height;
}
