package br.com.desafio.msdesafio.service;

import br.com.desafio.msdesafio.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    Order getOrderById(Long id);

    Order createOrder(Order order);

    Order updateOrder(Order order);

    void deleteOrder(Long id);
}