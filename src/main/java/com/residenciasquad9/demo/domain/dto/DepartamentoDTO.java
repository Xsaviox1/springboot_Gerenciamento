package com.residenciasquad9.demo.domain.dto;

import com.residenciasquad9.demo.domain.enums.TipoDepartamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoDTO {

    private Long idDepartamento;          // ID do departamento
    private String nome;                  // Nome do departamento
    private String descricao;             // Descrição do departamento
    private TipoDepartamento tipoDepartamento;  // Tipo do departamento
}
