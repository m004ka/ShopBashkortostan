package org.urr.shopbashkortostan.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.urr.shopbashkortostan.models.Product;
import org.urr.shopbashkortostan.service.Impl.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor

public class CartController {


    private final CartService cartService;

    @PostMapping("/add")
    public void addToCart(@RequestBody Product product, @RequestParam int quantity, Authentication authentication) {
       cartService.addToCart(product, quantity, authentication);
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
