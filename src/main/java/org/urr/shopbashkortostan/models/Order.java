package org.urr.shopbashkortostan.models;

import jakarta.persistence.*;
import lombok.*;
import org.urr.shopbashkortostan.enums.Address;
import org.urr.shopbashkortostan.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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

    @GeneratedValue(strategy = GenerationType.UUID)
    private Long orderId;

    @ManyToOne
    Account account;



    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<CartItem> cartItems;

    private BigDecimal exactAmount;

    private BigDecimal exactWeight;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Address address;

}