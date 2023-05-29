package br.com.desafio.msdesafio.controller.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserRequest {

    private Long id;

    private String username;

    private String password;
    
}