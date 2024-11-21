package com.residenciasquad9.demo.domain.dto;

import com.residenciasquad9.demo.domain.enums.TipoCliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {

    private Integer id;            // Identificador único da conta
    private String cpf;            // CPF do cliente associado
    private String agencia;        // Número da agência bancária
    private String numeroConta;    // Número da conta bancária
    private TipoCliente tipoCliente; // Tipo de cliente (Pessoa Física ou Jurídica)
    private Long titularId;        // ID do titular associado à conta
}
