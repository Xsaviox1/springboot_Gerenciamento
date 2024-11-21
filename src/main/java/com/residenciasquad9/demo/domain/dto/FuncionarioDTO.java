package com.residenciasquad9.demo.domain.dto;

import com.residenciasquad9.demo.domain.enums.TipoFuncionario;
import lombok.Data;

@Data
public class FuncionarioDTO {

    private String cpf;                // CPF do funcionário
    private String nome;               // Nome do funcionário
    private String email;              // E-mail do funcionário
    private Long departamentoId;       // ID do Departamento (relacionamento com Departamento)
    private TipoFuncionario statusFunc; // Status do funcionário (ativo/inativo)
}
