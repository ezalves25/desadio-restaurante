package br.com.desafio.msdesafio.mappers;

import br.com.desafio.msdesafio.controller.request.OrderRequest;
import br.com.desafio.msdesafio.model.Customer;
import br.com.desafio.msdesafio.model.Order;

public class OrderMapper {


    public static Order convert(OrderRequest request) throws Exception {
        try {
            Customer customer = Customer.builder().id(request.getCustomer()).build();
            return Order.builder()
                    .id(request.getId())
                    .description(request.getDescription())
                    .customer(customer).build();
        } catch (Exception e) {
            throw new Exception("Erro mapper order");
        }
    }
}
