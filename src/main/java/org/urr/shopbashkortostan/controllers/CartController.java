package org.urr.shopbashkortostan.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.urr.shopbashkortostan.dto.AddCartDTO;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.models.CartItem;
import org.urr.shopbashkortostan.models.Product;
import org.urr.shopbashkortostan.repositories.ProductRepository;
import org.urr.shopbashkortostan.service.Impl.AccountService;
import org.urr.shopbashkortostan.service.Impl.CartService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor

public class CartController {


    private final CartService cartService;
    private final AccountService accountService;
    private final ProductRepository productRepository;

    @PostMapping("/add")
    public void addToCart(@RequestBody AddCartDTO addCartDTO, Authentication authentication) {
        Account account = accountService.getAccountFromAuthentication(authentication).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        Product product = productRepository.getProductById(addCartDTO.getProductId());
        cartService.addToCart(product, addCartDTO.getQuantity(), account);
    }

    @DeleteMapping("/remove")
    public void removeFromCart(@RequestParam Long id, Authentication authentication) {
        Account account = accountService.getAccountFromAuthentication(authentication).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        cartService.removeFromCart(id, account);
    }

    @PutMapping("/update")
    public void updateCartItemQuantity(@RequestParam Long productId, @RequestParam int quantity, Authentication authentication) {
        Account account = accountService.getAccountFromAuthentication(authentication).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        cartService.updateCartItemQuantity(productId, quantity, account);
    }

    @GetMapping("/items")
    public List<CartItem> getCartItems(Authentication authentication) {
        Account account = accountService.getAccountFromAuthentication(authentication).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        return cartService.getCartItems(account);
        //return  List.of(); //условно
    }

    @DeleteMapping("/clear")
    public void clearCart(Authentication authentication) {
        Account account = accountService.getAccountFromAuthentication(authentication).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        cartService.clearCart(account);
    }

    @GetMapping("/total")
    public BigDecimal getCartTotal(Authentication authentication) {
        Account account = accountService.getAccountFromAuthentication(authentication).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        return cartService.getCartTotal(account);
    }

    @GetMapping("/weight")
    public BigDecimal getCartWeight(Authentication authentication) {
        Account account = accountService.getAccountFromAuthentication(authentication).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        return cartService.getCartWeight(account);
    }

    @PostMapping("/checkout")
    public void checkout() {
        // Логика оформления заказа и очистки корзины
    }


}
