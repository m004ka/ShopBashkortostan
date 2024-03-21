package org.urr.shopbashkortostan.service.Impl;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.models.Cart;
import org.urr.shopbashkortostan.models.CartItem;
import org.urr.shopbashkortostan.models.Product;
import org.urr.shopbashkortostan.repositories.AccountRepository;
import org.urr.shopbashkortostan.repositories.CartRepository;
import org.urr.shopbashkortostan.repositories.ProductRepository;

import java.io.Console;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartService {


    private final CartRepository cartRepository; // Репозиторий для работы с корзинами
    private final AccountService accountService;
    private final ProductRepository productRepository;


    @Transactional
    public void addToCart(Product product, int quantity, Account account) {
        Cart cart = account.getCart();
        List<CartItem> cartItems = cart.getCartItems();
        CartItem cartItem = cartItems.stream().filter(p -> {

            return p.getProduct().getId().equals(product.getId());
        }).findFirst().orElse(CartItem.builder().product(product).build());
        cartItem.setQuantity(cartItem.getQuantity() + quantity);
        if (!cartItems.contains(cartItem)) cartItems.add(cartItem);

        cartRepository.save(cart);
        getCartWeight(account);
        getCartTotal(account);
    }

    public void removeFromCart(Long productId, Account account) {
        Cart cart = account.getCart();
        List<CartItem> cartItems = cart.getCartItems();
        CartItem cartItem = cartItems.stream().filter(p -> {
            System.out.println("\n\n\n\n АЙДИ " + p.getId() + "\n\n");
            return p.getProduct().getId().equals(productId);
        }).findFirst().orElseThrow(() -> new RuntimeException("item not found with id: " + productId));
        cartItems.remove(cartItem);
        cartRepository.save(cart);
        getCartWeight(account);
        getCartTotal(account);
    }

    public void updateCartItemQuantity(Long productId, int quantity, Account account) {
        Cart cart = account.getCart();
        List<CartItem> cartItems = cart.getCartItems();
        CartItem cartItem = cartItems.stream().filter(p -> {
            // System.out.println("\n\n\n\n АЙДИ " + p.getId() + "\n\n");
            return p.getProduct().getId().equals(productId);
        }).findFirst().orElseThrow(() -> new RuntimeException("item not found with id: " + productId));
        cartItem.setQuantity(cartItem.getQuantity() + quantity);
        cartRepository.save(cart);
        getCartWeight(account);
        getCartTotal(account);
    }

    public List<CartItem> getCartItems(Account account) {
        Cart cart = account.getCart();
        return cart.getCartItems();
    }

    public void clearCart(Account account) {
        Cart cart = account.getCart();
        cart.setCartItems(List.of());
        cartRepository.save(cart);
        getCartWeight(account);
        getCartTotal(account);
    }

    public BigDecimal getCartTotal(Account account) {
        Cart cart = account.getCart();
        BigDecimal total = BigDecimal.valueOf(0);
        int quantity = 0;
        BigDecimal price = BigDecimal.valueOf(0);
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem elem : cartItems) {
            quantity = elem.getQuantity();
            price = elem.getProduct().getPrice();
            total = total.add(price.multiply(BigDecimal.valueOf(quantity)));
        }
        cart.setTotalAmount(total);
        cartRepository.save(cart);
        return total;
    }

    public BigDecimal getCartWeight(Account account) {
        Cart cart = account.getCart();
        BigDecimal totalweight = BigDecimal.valueOf(0);
        int quantity = 0;
        BigDecimal weight = BigDecimal.valueOf(0);
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem elem : cartItems) {
            quantity = elem.getQuantity();
            weight = elem.getProduct().getWeight();
            totalweight = totalweight.add(weight.multiply(BigDecimal.valueOf(quantity)));
        }
        cart.setTotalWeight(totalweight);
        cartRepository.save(cart);
        return totalweight;
    }
}
