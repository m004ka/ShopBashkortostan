package org.urr.shopbashkortostan.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.urr.shopbashkortostan.dto.AddCartDTO;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.models.Product;
import org.urr.shopbashkortostan.repositories.ProductRepository;
import org.urr.shopbashkortostan.service.Impl.AccountService;
import org.urr.shopbashkortostan.service.Impl.CartService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor

public class CartController {


    private final CartService cartService;
    private final AccountService accountService;
    private final ProductRepository productRepository;

    @PostMapping("/add")
    public void addToCart(@RequestBody AddCartDTO addCartDTO, Authentication authentication) {
        Account account = accountService.getAccountFromAuthentication(authentication).orElseThrow(()-> new RuntimeException("Аккаунт не найден"));
        Product product = productRepository.getProductById(addCartDTO.getId());
        cartService.addToCart(product, addCartDTO.getQuantity(), account);
    }

    @DeleteMapping("/remove")
    public void removeFromCart(@RequestParam Long productId) {
        cartService.removeFromCart(productId);
    }

    @PutMapping("/update")
    public void updateCartItemQuantity(@RequestParam Long productId, @RequestParam int quantity) {
        cartService.updateCartItemQuantity(productId, quantity);
    }
    @GetMapping("/items")
    public List<Product> getCartItems() {
        //cartService.getCartItems();
        return  List.of(); //условно
    }

    @DeleteMapping("/clear")
    public void clearCart() {
        //cartService.clearCart();
    }

    @GetMapping("/total")
    public double getCartTotal() {
        //cartService.getCartTotal();

        return 12;//условно
    }

    @PostMapping("/checkout")
    public void checkout() {
        // Логика оформления заказа и очистки корзины
    }


}
