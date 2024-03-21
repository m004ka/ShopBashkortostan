package org.urr.shopbashkortostan.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.urr.shopbashkortostan.dto.OrderDTO;
import org.urr.shopbashkortostan.enums.Address;
import org.urr.shopbashkortostan.enums.OrderStatus;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.models.Cart;
import org.urr.shopbashkortostan.models.Order;
import org.urr.shopbashkortostan.repositories.OrderRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    // Логика работы с заказами

    // Создание нового заказа
    public void createOrder(OrderDTO orderDTO, Account account) {
        Cart cart = account.getCart();
        Order order = Order.builder()
                .account(account)
                .orderDate(LocalDateTime.now())
                .cartItems(cart.getCartItems())
                .status(OrderStatus.ACCEPTED)
                .address(Address.UFAHIGHWAY)
                .exactWeight(cart.getTotalWeight())
                .exactAmount(cart.getTotalAmount())
                .build();
        orderRepository.save(order);
    }

    // Получение информации о конкретном заказе
    public Order getOrderById(Long orderId) {
        return orderRepository.findOrderByOrderId(orderId).orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
    }

    // Получение списка всех заказов пользователя
    public List<Order> getUserOrders(Account account) {
        return orderRepository.findOrdersByAccount_Id(account.getId());
    }

    // Обновление статуса заказа
    public void updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = orderRepository.findOrderByOrderId(orderId).orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
        order.setStatus(status);
        orderRepository.save(order);
    }

    // Отмена заказа
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findOrderByOrderId(orderId).orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
        order.setStatus(OrderStatus.CANCELLED);
    }

    // Рассчет общей стоимости заказа
    public double calculateOrderTotal(Long orderId) {
        // Логика рассчета общей стоимости заказа
        return 0.0;
    }

    // Удаление заказа
    public void deleteOrder(Long orderId) {
        // Логика удаления заказа
    }

    // Подтверждение заказа
    public void confirmOrder(Long orderId) {
        Order order = orderRepository.findOrderByOrderId(orderId).orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
        order.setStatus(OrderStatus.ACCEPTED);
        orderRepository.save(order);
    }

    // Получение списка заказов за определенный период
    public List<Order> getOrdersByPeriod(Date startDate, Date endDate) {
        // Логика получения списка заказов за определенный период //не надо нам пока такое
        return null;
    }

    // Другие методы могут быть реализованы в соответствии с требованиями вашего приложения
}