package org.urr.shopbashkortostan.repositories;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.urr.shopbashkortostan.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Id> { //id заменить
}
