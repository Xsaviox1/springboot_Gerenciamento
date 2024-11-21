package com.residenciasquad9.demo.domain.dto;

import com.residenciasquad9.demo.domain.enums.TipoCliente;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private String nome;
    private String cpf;
    private String email;
    private TipoCliente tipoCliente;
    private String cnpj;
    private Long telefoneIdTelefone;
}
