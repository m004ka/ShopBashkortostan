package org.urr.shopbashkortostan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.urr.shopbashkortostan.models.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
