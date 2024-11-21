package com.residenciasquad9.demo.domain.entites;

import com.residenciasquad9.demo.domain.enums.TipoFuncionario;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Funcionario")
public class Funcionario {

    @Id
    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "departamento", nullable = false, length = 45)
    private String departamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusFunc", nullable = false)
    private TipoFuncionario statusFunc;

    @ManyToOne
    @JoinColumn(name = "protocolo_id_protocolo", nullable = false)
    private Protocolo protocolo;

    @ManyToOne
    @JoinColumn(name = "cargo_id_cargo", nullable = false)
    private Cargo cargo;
}

