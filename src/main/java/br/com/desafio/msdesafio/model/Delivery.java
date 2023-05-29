package br.com.desafio.msdesafio.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_delivery")
    @SequenceGenerator(name = "pk_delivery", sequenceName = "sq_delivery", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private LocalDateTime deliveryDate;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
