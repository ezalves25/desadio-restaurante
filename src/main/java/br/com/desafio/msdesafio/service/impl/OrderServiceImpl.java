package br.com.desafio.msdesafio.service.impl;

import br.com.desafio.msdesafio.model.Customer;
import br.com.desafio.msdesafio.model.Order;
import br.com.desafio.msdesafio.repository.CustomerRepository;
import br.com.desafio.msdesafio.repository.OrderRepository;
import br.com.desafio.msdesafio.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        Optional<Customer> optionalCustomer = customerRepository.findById(order.getCustomer().getId());
        order.setCustomer(optionalCustomer.get());
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}