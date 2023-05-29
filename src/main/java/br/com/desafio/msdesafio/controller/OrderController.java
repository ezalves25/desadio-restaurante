package br.com.desafio.msdesafio.controller;

import br.com.desafio.msdesafio.controller.request.OrderRequest;
import br.com.desafio.msdesafio.mappers.OrderMapper;
import br.com.desafio.msdesafio.model.Order;
import br.com.desafio.msdesafio.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest request) throws Exception {
        Order order = orderService.createOrder(OrderMapper.convert(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PutMapping
    public ResponseEntity<Order> updateOrder(@RequestBody OrderRequest request) throws Exception {
        Order order = orderService.createOrder(OrderMapper.convert(request));
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}