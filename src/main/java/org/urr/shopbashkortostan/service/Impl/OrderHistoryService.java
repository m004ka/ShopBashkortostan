package org.urr.shopbashkortostan.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.models.Order;
import org.urr.shopbashkortostan.models.OrderHistory;
import org.urr.shopbashkortostan.repositories.OrderHistoryRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderHistoryService {
    private final OrderHistoryRepository orderHistoryRepository;
   public List<OrderHistory> getOrderHistoryAccount(Account account){
      return orderHistoryRepository.findOrdersByAccount_Id(account.getId());
   }
   public void AddOrderToHistory(Order order){
       OrderHistory orderHistory = OrderHistory.builder()
               .account(order.getAccount())
               .order(order)
               .build();
       orderHistoryRepository.save(orderHistory);
   }
   public void DeleteOrderToHistory(Account account, Long id){
       OrderHistory orderHistory = orderHistoryRepository.findOrderHistoryByAccountAndId(account
               ,id).orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        orderHistoryRepository.delete(orderHistory);
   }
}
