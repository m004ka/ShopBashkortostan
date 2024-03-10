package org.urr.shopbashkortostan.service.interfaces;

import org.urr.shopbashkortostan.models.CartItem;
import org.urr.shopbashkortostan.models.Product;

import java.util.List;

public interface CartService {
    void addToCart(Product product, int quantity);

    void removeFromCart(Long productId);

    void updateCartItemQuantity(Long productId, int quantity);

    List<CartItem> getCartItems();
    void clearCart();

    double getCartTotal();
}
