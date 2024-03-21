package org.urr.shopbashkortostan.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.urr.shopbashkortostan.dto.OrderDTO;
import org.urr.shopbashkortostan.enums.OrderStatus;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.models.Order;
import org.urr.shopbashkortostan.repositories.AccountRepository;
import org.urr.shopbashkortostan.service.Impl.AccountService;
import org.urr.shopbashkortostan.service.Impl.OrderService;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final AccountService accountService;

    // 1. Создание нового заказа
    @PostMapping("/create")
    public void createOrder(@RequestBody OrderDTO orderDTO, Authentication authentication) {
        Account account = accountService.getAccountFromAuthentication(authentication).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        orderService.createOrder(orderDTO, account);
    }

    // 2. Получение информации о конкретном заказе
    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    // 3. Получение списка всех заказов пользователя
    @GetMapping("/user")
    public List<Order> getUserOrders(Authentication authentication) {
        Account account = accountService.getAccountFromAuthentication(authentication).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        return orderService.getUserOrders(account);
    }

    // 4. Обновление статуса заказа
    @PutMapping("/{orderId}/update-status")
    public void updateOrderStatus(@PathVariable Long orderId, @RequestParam OrderStatus status) {
        orderService.updateOrderStatus(orderId, status);
    }

    // 5. Отмена заказа
    @PutMapping("/{orderId}/cancel")
    public void cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
    }

    // 6. Рассчет общей стоимости заказа
    @GetMapping("/{orderId}/total")
    public double calculateOrderTotal(@PathVariable Long orderId) {
        return orderService.calculateOrderTotal(orderId);
    }

    // 7. Удаление заказа
    @DeleteMapping("/{orderId}/delete")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }

    // 8. Подтверждение заказа
    @PostMapping("/{orderId}/confirm")
    public void confirmOrder(@PathVariable Long orderId) {
        orderService.confirmOrder(orderId);
    }

    // 9. Получение списка заказов за определенный период
    @GetMapping("/period")
    public List<Order> getOrdersByPeriod(@RequestParam Date startDate, @RequestParam Date endDate) {
        return orderService.getOrdersByPeriod(startDate, endDate);
    }
}
