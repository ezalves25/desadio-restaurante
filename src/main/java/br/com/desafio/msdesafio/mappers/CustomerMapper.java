package br.com.desafio.msdesafio.mappers;

import br.com.desafio.msdesafio.controller.request.CustomerRequest;
import br.com.desafio.msdesafio.model.Customer;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Lazy
@Component
public class CustomerMapper implements Converter<CustomerRequest, Customer> {


    @Override
    @NonNull
    public Customer convert(final CustomerRequest request) {
        try {
            return Customer.builder()
                    .id(request.getId())
                    .lastName(request.getLastName())
                    .firstName(request.getFirstName())
                    .email(request.getEmail())
                    .build();
        } catch (final Exception ex) {
            log.error("Mapper Error Bind");
            throw new RuntimeException(ex);
        }
    }
}