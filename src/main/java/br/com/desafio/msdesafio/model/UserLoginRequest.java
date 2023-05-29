package br.com.desafio.msdesafio.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {


    private String username;


    private String password;


    private String role;

}