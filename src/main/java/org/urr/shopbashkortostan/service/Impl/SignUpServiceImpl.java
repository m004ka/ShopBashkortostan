package org.urr.shopbashkortostan.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.urr.shopbashkortostan.models.Cart;
import org.urr.shopbashkortostan.repositories.CartRepository;
import org.urr.shopbashkortostan.service.interfaces.SignUpService;
import org.urr.shopbashkortostan.dto.SignUpForm;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.repositories.AccountRepository;

@Service
@RequiredArgsConstructor

public class SignUpServiceImpl implements SignUpService {

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private final CartRepository cartRepository;

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

        Cart cart = Cart.builder()
                .account(account)
                .build();
        cartRepository.save(cart);
    }
}
