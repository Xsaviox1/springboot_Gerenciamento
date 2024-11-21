package com.residenciasquad9.demo.domain.entites;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "agencia", nullable = false, length = 10)
    private String agencia;

    @Column(name = "numero_conta", nullable = false, length = 20)
    private String numeroConta;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false) // Relacionamento com um cliente
    private Cliente cliente;
}
