package com.residenciasquad9.demo.domain.entites;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "titulares")
public class Titular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_titular")
    private Long idTitular;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "email", nullable = false)
    private String email;

    // Relacionamento com Cliente
    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;
}
