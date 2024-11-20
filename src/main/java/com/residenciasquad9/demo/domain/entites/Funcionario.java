package com.residenciasquad9.demo.domain.entites;

import com.residenciasquad9.demo.domain.enums.StatusFunc;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Funcionario")
public class Funcionario {

    @Id
    @Column(name = "codigo_funcional", length = 14)
    private String codigoFuncional;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "departamento", nullable = false, length = 45)
    private String departamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusFunc status;

    @ManyToOne
    @JoinColumn(name = "protocolo_id_protocolo", nullable = false)
    private Protocolo protocolo;

    @ManyToOne
    @JoinColumn(name = "cargo_id_cargo", nullable = false)
    private Cargo cargo;
}
