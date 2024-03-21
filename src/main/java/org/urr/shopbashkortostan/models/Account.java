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
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String fullName;
    private String password;
    private String phoneNumber;
    private String email;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account", orphanRemoval = true)
    private Cart cart = Cart.builder().account(this).build();
    public enum Role {
        ADMIN, USER, MODER
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "Role")
    private Role role;

}
