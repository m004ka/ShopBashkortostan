package org.urr.shopbashkortostan.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.repositories.AccountRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepository.findAccountByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User" + username + "not found")));

        return UserDetailsImpl.build(account);
    }

    public Optional<Account> getAccountFromAuthentication(Authentication authentication) {


        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            Optional<Account> account = accountRepository.findAccountByUsername(authentication.getName());
            if(account.isPresent()){
                return account;
            }
        }
        return null;
    }
}
