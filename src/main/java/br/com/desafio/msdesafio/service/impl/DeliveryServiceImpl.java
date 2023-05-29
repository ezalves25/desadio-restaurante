package br.com.desafio.msdesafio.service.impl;

import br.com.desafio.msdesafio.model.Delivery;
import br.com.desafio.msdesafio.model.Order;
import br.com.desafio.msdesafio.repository.DeliveryRepository;
import br.com.desafio.msdesafio.service.DeliveryService;
import br.com.desafio.msdesafio.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    private final OrderService orderService;


    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, OrderService orderService) {
        this.deliveryRepository = deliveryRepository;
        this.orderService = orderService;
    }

    @Override
    public Delivery createDelivery(Delivery delivery) {
        Order order = orderService.getOrderById(delivery.getOrder().getId());
        delivery.setOrder(order);
        delivery.setDeliveryDate(LocalDateTime.now());
        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Delivery not found"));
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    @Override
    public void updateDelivery(Delivery delivery) {
        if (!deliveryRepository.existsById(delivery.getId())) {
            throw new NotFoundException("Delivery not found");
        }
        deliveryRepository.save(delivery);
    }

    @Override
    public void deleteDelivery(Long id) {
        if (!deliveryRepository.existsById(id)) {
            throw new NotFoundException("Delivery not found");
        }
        deliveryRepository.deleteById(id);
    }
}