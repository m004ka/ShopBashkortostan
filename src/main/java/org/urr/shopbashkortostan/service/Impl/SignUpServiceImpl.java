package org.urr.shopbashkortostan.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.urr.shopbashkortostan.service.interfaces.SignUpService;
import org.urr.shopbashkortostan.dto.SignUpForm;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.repositories.AccountRepository;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final AccountRepository accountRepository;

    @Override
    public void SignUp(SignUpForm form) {
        Account account = Account.builder()
                .email(form.getEmail())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .password(form.getPassword())
                .build();
        accountRepository.save(account);
    }
}
