package org.urr.shopbashkortostan.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Favorites {

    @Id
    @OneToOne
    private Account account;
    @OneToOne
    private Product product;

    String text;
}
