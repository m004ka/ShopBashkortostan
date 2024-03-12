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
import org.urr.shopbashkortostan.repositories.CartItemRepository;
import org.urr.shopbashkortostan.repositories.CartRepository;
import org.urr.shopbashkortostan.repositories.ProductRepository;

import java.io.Console;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartService {


    private final CartRepository cartRepository; // Репозиторий для работы с корзинами
    private final CartItemServiceImpl cartItemService;
    private final AccountService accountService;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void addToCart(Product product, int quantity, Account account) {
        Cart cart = cartRepository.findByAccountId(account.getId()).orElseThrow(() -> new RuntimeException("Корзина не найдена"));
        Hibernate.initialize(cart.getCartItems());
        CartItem cartItem = CartItem.builder()
                .product(product)
                .quantity(quantity)
                .build();
        cartItemRepository.save(cartItem);

        cart.getCartItems().add(cartItem);
        cartRepository.save(cart);
    }

    public void removeFromCart(Long productId) {
        // Логика удаления товара из корзины в базе данных
    }

    public void updateCartItemQuantity(Long productId, int quantity) {
        // Логика обновления количества товара в корзине в базе данных
    }

//    public List<CartItem> getCartItems(Long cartId) {
//        // Логика получения списка товаров в корзине из базы данных
//    }

    public void clearCart(Long cartId) {
        // Логика очистки корзины в базе данных
    }

//    public BigDecimal getCartTotal(Long cartId) {
//        // Логика расчета общей стоимости товаров в корзине из базы данных
//        return
//    }
}
