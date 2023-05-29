package br.com.desafio.msdesafio.controller;

import br.com.desafio.msdesafio.controller.request.DeliveryRequest;
import br.com.desafio.msdesafio.mappers.DeliveryMapper;
import br.com.desafio.msdesafio.model.Delivery;
import br.com.desafio.msdesafio.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping
    public ResponseEntity<Delivery> createDelivery(@RequestBody DeliveryRequest request) throws Exception {
        Delivery createdDelivery = deliveryService.createDelivery(DeliveryMapper.convert(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDelivery);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable Long id) {
        Delivery delivery = deliveryService.getDeliveryById(id);
        return ResponseEntity.ok(delivery);
    }

    @GetMapping
    public ResponseEntity<List<Delivery>> getAllDeliveries() {
        List<Delivery> deliveries = deliveryService.getAllDeliveries();
        return ResponseEntity.ok(deliveries);
    }

    @PutMapping
    public ResponseEntity<Void> updateDelivery(@RequestBody DeliveryRequest request) throws Exception {
        Delivery createdDelivery = deliveryService.createDelivery(DeliveryMapper.convert(request));
        deliveryService.updateDelivery(createdDelivery);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
        return ResponseEntity.noContent().build();
    }
}