package com.residenciasquad9.demo.domain.entites;

import com.residenciasquad9.demo.domain.entites.Cliente;
import com.residenciasquad9.demo.domain.entites.Titular;
import com.residenciasquad9.demo.domain.enums.TipoCliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Integer idConta;

    @Column(name = "agencia", nullable = false, length = 5)
    private String agencia;

    @Column(name = "numero_conta", nullable = false, length = 8)
    private String numeroConta;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cliente", nullable = false)
    private TipoCliente tipoCliente;

    @ManyToOne
    @JoinColumn(name = "cliente_id_cliente", nullable = false, referencedColumnName = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "titular_id_titular", nullable = false, referencedColumnName = "id_titular")
    private Titular titular;
}

