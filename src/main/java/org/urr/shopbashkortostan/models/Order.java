package org.urr.shopbashkortostan.models;

import jakarta.persistence.*;
import lombok.*;
import org.urr.shopbashkortostan.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Ordeer")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    Account account;

    private BigDecimal exactAmount;

    private BigDecimal amountWithVAT;

    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private String address;

}