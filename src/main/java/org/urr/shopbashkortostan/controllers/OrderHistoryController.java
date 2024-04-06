package org.urr.shopbashkortostan.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.models.OrderHistory;
import org.urr.shopbashkortostan.service.Impl.AccountService;
import org.urr.shopbashkortostan.service.Impl.OrderHistoryService;

import java.util.List;

@RestController
@RequestMapping("/api/orderHistory")
@RequiredArgsConstructor
public class OrderHistoryController {
    private final AccountService accountService;
    private final OrderHistoryService orderHistoryService;
    @GetMapping("/get")
    public List<OrderHistory> getOrderHistory(Authentication authentication){
        Account account = accountService.getAccountFromAuthentication(authentication).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        return orderHistoryService.getOrderHistoryAccount(account);
    }
    @DeleteMapping("/orderOfHistory/{Id}")
    public void DeleteOrderOfHistory(Authentication authentication, @PathVariable Long Id){
        Account account = accountService.getAccountFromAuthentication(authentication).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        orderHistoryService.DeleteOrderToHistory(account, Id);
    }

}
