package org.urr.shopbashkortostan.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.urr.shopbashkortostan.models.CartItem;
import org.urr.shopbashkortostan.models.Product;
import org.urr.shopbashkortostan.repositories.CartItemRepository;
import org.urr.shopbashkortostan.service.interfaces.CartItemService;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    @Override
    public void addItemToCart(Product product, int quantity) {

        CartItem cartItem = CartItem.builder()
                
                .product(product)
                .quantity(quantity)
                .build();
        cartItemRepository.save(cartItem);
    }
}
