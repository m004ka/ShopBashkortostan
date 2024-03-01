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

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "Email")
    private String email;

    public enum Role {
        ADMIN, USER, MODER
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "Role")
    private Role role;

}
