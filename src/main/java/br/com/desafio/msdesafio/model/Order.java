package br.com.desafio.msdesafio.model;


import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_order")
    @SequenceGenerator(name = "pk_order", sequenceName = "sq_order", initialValue = 1, allocationSize = 1)
    private Long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}