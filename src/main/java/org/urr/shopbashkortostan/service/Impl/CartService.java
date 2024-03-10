package org.urr.shopbashkortostan.service.Impl;

import org.springframework.stereotype.Service;
import org.urr.shopbashkortostan.models.CartItem;
import org.urr.shopbashkortostan.models.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    private Map<Long, CartItem> cartItems = new HashMap<>();

    // Добавление товара в корзину
    public void addToCart(Product product, int quantity) {
        if (cartItems.containsKey(product.getId())) {
            CartItem item = cartItems.get(product.getId());
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            cartItems.put(product.getId(), new CartItem(product, quantity));
        }
    }

    // Удаление товара из корзины
    public void removeFromCart(Long productId) {
        cartItems.remove(productId);
    }

    // Изменение количества товара в корзине
    public void updateCartItemQuantity(Long productId, int quantity) {
        if (cartItems.containsKey(productId)) {
            cartItems.get(productId).setQuantity(quantity);
        }
    }

    // Получение информации о товарах в корзине
    public List<CartItem> getCartItems() {
        return new ArrayList<>(cartItems.values());
    }

    // Очистка корзины
    public void clearCart() {
        cartItems.clear();
    }

    // Рассчет общей стоимости товаров в корзине
    public double getCartTotal() {
        double total = 0.0;
        for (CartItem item : cartItems.values()) {
            total += item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())).doubleValue();
        }
        return total;
    }


}