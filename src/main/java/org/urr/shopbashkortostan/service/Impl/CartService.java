package org.urr.shopbashkortostan.service.Impl;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.models.Cart;
import org.urr.shopbashkortostan.models.Product;
import org.urr.shopbashkortostan.repositories.AccountRepository;
import org.urr.shopbashkortostan.repositories.CartRepository;

import java.io.Console;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartService {


    private final CartRepository cartRepository; // Репозиторий для работы с корзинами
    private final AccountRepository accountRepository;
    private final AccountService accountService;

    public void addToCart(Product product, int quantity, Authentication authentication) {
        Long id = null;
        System.out.println("ид аккаунта = " + id);
        Optional<Account> account = accountService.getAccountFromAuthentication(authentication);
        if(account.isPresent()){
            id = account.get().getId();
            System.out.println("ид аккаунта = " + id);
        }
        Cart cart = cartRepository.findByAccountId(id).orElseThrow(() -> new RuntimeException("Cart not found"));
        System.out.println(cart);

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
