package org.urr.shopbashkortostan.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    Product product;

    String text;

    @OneToOne
    Account account;

    public enum Rating {
        ONE, TWO, THREE, FOUR, FIVE
    }

    Date date;
}
