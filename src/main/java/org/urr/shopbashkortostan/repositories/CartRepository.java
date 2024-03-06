package org.urr.shopbashkortostan.repositories;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.urr.shopbashkortostan.models.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
