package br.com.desafio.msdesafio.controller.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CustomerRequest {

    private Long id;
    private String firstName;
    private String lastName;
    
    private String email;

}