package org.urr.shopbashkortostan.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.urr.shopbashkortostan.TokenJWT.JwtCore;
import org.urr.shopbashkortostan.dto.SignUpForm;
import org.urr.shopbashkortostan.dto.SingInForm;
import org.urr.shopbashkortostan.repositories.AccountRepository;
import org.urr.shopbashkortostan.service.Impl.SignUpServiceImpl;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class SecurityController {

    private final SignUpServiceImpl signUpService;
    private final AuthenticationManager authenticationManager;
    private final AccountRepository accountRepository;

    private final JwtCore jwtCore;

    @PostMapping("/signUp")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> singUp(@RequestBody SignUpForm signUpForm) {
        if (accountRepository.existsAccountByUsername(signUpForm.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Choose different name");
        }
        if (accountRepository.existsAccountByEmail(signUpForm.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Choose different email");
        }
        signUpService.SignUp(signUpForm);
        return ResponseEntity.ok("Success body");
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<?> signin(@RequestBody SingInForm singInForm) {
        Authentication authentication = null;
        try {

            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(singInForm.getUsername(), singInForm.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtCore.generateToken(authentication);
        return ResponseEntity.ok(jwt);
    }

}
