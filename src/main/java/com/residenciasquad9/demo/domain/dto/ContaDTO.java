package com.residenciasquad9.demo.domain.dto;

import com.residenciasquad9.demo.domain.enums.TipoCliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {

    private Integer idConta;           // ID da conta
    private String agencia;            // Número da agência
    private String numeroConta;        // Número da conta
    private TipoCliente tipoCliente;   // Tipo de cliente (Pessoa Física ou Jurídica)
    private Long clienteId;            // ID do cliente associado à conta
    private Long titularId;            // ID do titular associado à conta
}

