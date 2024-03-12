package org.urr.shopbashkortostan.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.urr.shopbashkortostan.service.interfaces.SignUpService;
import org.urr.shopbashkortostan.dto.SignUpForm;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.repositories.AccountRepository;

@Service
@RequiredArgsConstructor

public class SignUpServiceImpl implements SignUpService {

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    @Override
    public void SignUp(SignUpForm form) {
        Account account = Account.builder()
                .email(form.getEmail())
                .username(form.getUsername())
                .fullName(form.getFullName())
                .phoneNumber(form.getPhoneNumber())
                .password(passwordEncoder.encode(form.getPassword()))
                .role(Account.Role.USER)
                .build();
        accountRepository.save(account);
    }
}
