package org.urr.shopbashkortostan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.urr.shopbashkortostan.models.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
