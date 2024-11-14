package com.residenciasquad9.demo.domain.entites;

import com.residenciasquad9.demo.domain.enums.Status;
import com.residenciasquad9.demo.domain.enums.TipoConta;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Conta")
public class Conta {
    // Atributo
    private int idConta;
    private String agencia;
    private String numeroConta;
    private TipoConta tipoCliente;
    private Date dataAbertura;
    private Date dataPrazo;
    private String descricao;
    private Status status;

    // relacionamento com Titular
    private Titular titular;

    // relacionamento com Cliente
    private Cliente cliente;
}
