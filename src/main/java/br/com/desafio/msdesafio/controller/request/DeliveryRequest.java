package br.com.desafio.msdesafio.controller.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DeliveryRequest {

    private Long id;

    private String address;
    private Long order;
}
