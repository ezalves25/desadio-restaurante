package br.com.desafio.msdesafio.service;

import br.com.desafio.msdesafio.model.Delivery;

import java.util.List;

public interface DeliveryService {

    Delivery createDelivery(Delivery delivery);

    Delivery getDeliveryById(Long id);

    List<Delivery> getAllDeliveries();

    void updateDelivery(Delivery delivery);

    void deleteDelivery(Long id);
}