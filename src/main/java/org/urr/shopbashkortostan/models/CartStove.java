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
public class CartStove {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "Price")
    private BigDecimal price;
    private float priceForMeterSquare;
    @Column(name = "Description")
    private String Text;


    private enum Size {
        SIZE_15, SIZE_25,SIZE_35,SIZE_50, SIZE_100
    }
    @Column(name = "Size")
    private Size size;

    @Column(name = "Desitny")
    private int density;
    @Column(name = "Mark")
    private String mark;

    @Column(name = "Height")
    private float height;
}
