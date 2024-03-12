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
    private String username;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;
}
