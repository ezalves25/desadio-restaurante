package br.com.desafio.msdesafio.mappers;

import br.com.desafio.msdesafio.controller.request.DeliveryRequest;
import br.com.desafio.msdesafio.model.Delivery;
import br.com.desafio.msdesafio.model.Order;

public class DeliveryMapper {


    public static Delivery convert(DeliveryRequest request) throws Exception {
        try {
            Order order = Order.builder().id(request.getOrder()).build();
            return Delivery.builder()
                    .id(request.getId())
                    .address(request.getAddress())
                    .order(order)
                    .build();
        } catch (Exception e) {
            throw new Exception("Erro mapper order");
        }
    }
}
