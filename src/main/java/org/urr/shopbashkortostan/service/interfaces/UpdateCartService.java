package org.urr.shopbashkortostan.service.interfaces;

import org.urr.shopbashkortostan.dto.CartForm;

public interface UpdateCartService {
    void updateCart(CartForm cartForm , CartForm cartFormNew);
}
