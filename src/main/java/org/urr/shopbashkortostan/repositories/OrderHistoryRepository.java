package org.urr.shopbashkortostan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.models.Order;
import org.urr.shopbashkortostan.models.OrderHistory;

import java.util.List;
import java.util.Optional;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {

    List<OrderHistory> findOrdersByAccount_Id(Long id);

    Optional<OrderHistory> findOrderHistoryByAccountAndId(Account account,Long id);

}
