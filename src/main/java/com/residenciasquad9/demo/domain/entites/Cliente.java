package com.residenciasquad9.demo.domain.entites;

import com.residenciasquad9.demo.domain.enums.TipoCliente;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")  // Ajuste na tabela, seguindo a convenção plural
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "email", nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cliente", nullable = false)
    private TipoCliente tipoCliente;

    @Column(name = "cnpj", unique = true)
    private String cnpj;

    @Column(name = "telefone_id_telefone")
    private Long telefoneIdTelefone;
}
