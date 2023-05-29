package br.com.desafio.msdesafio.controller.request;


import lombok.*;

@Builder
@Getter
@Setter
public class OrderRequest {

    private Long id;
    
    private String Description;

    private Long customer;

}