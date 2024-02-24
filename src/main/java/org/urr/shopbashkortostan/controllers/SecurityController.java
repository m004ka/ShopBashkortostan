package org.urr.shopbashkortostan.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.urr.shopbashkortostan.JwtCore;
import org.urr.shopbashkortostan.dto.SignUpForm;
import org.urr.shopbashkortostan.dto.SingInForm;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.repositories.AccountRepository;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class SecurityController {

    private final AuthenticationManager authenticationManager;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtCore jwtCore;

    @PostMapping("/signUp")
    ResponseEntity<?> singUp(@RequestBody SignUpForm signUpForm) {
        if (accountRepository.existsAccountByFirstName(signUpForm.getFirstName())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Choose different name");
        }
        if (accountRepository.existsAccountByEmail(signUpForm.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Choose different email");
        }
        Account account = new Account();
        account.setFirstName(signUpForm.getFirstName());
        account.setEmail(signUpForm.getEmail());
        account.setPassword(passwordEncoder.encode(signUpForm.getPassword()));
        accountRepository.save(account);
        return ResponseEntity.ok("Success body");
    }

    @PostMapping("/signin")
    ResponseEntity<?> signin(@RequestBody SingInForm singInForm) {
        Authentication authentication = null;
        try {

            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(singInForm.getFirstName(), singInForm.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtCore.generateToken(authentication);
        return ResponseEntity.ok(jwt);
    }
}
