package br.com.desafio.msdesafio.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_customer")
public class Customer {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_customer")
    @SequenceGenerator(name = "pk_customer", sequenceName = "sq_customer", initialValue = 1, allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    private String firstName;
    private String lastName;

    private String email;

}