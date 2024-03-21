package org.urr.shopbashkortostan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.urr.shopbashkortostan.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findOrderByOrderId(Long orderId);

    List<Order> findOrdersByAccount_Id(Long id);
}
