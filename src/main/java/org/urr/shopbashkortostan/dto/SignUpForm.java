package org.urr.shopbashkortostan.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpForm {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
