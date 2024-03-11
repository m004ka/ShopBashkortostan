package org.urr.shopbashkortostan.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.urr.shopbashkortostan.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Account account;

    @OneToMany
    private List<Product> products;
    private BigDecimal totalAmount;
    private BigDecimal totalWeight;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}

