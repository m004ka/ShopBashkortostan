package org.urr.shopbashkortostan.service.interfaces;

import org.urr.shopbashkortostan.models.Product;

public interface CartItemService {
    void addItemToCart(Product product, int quantity);
}
