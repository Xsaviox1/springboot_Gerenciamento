package com.residenciasquad9.demo.domain.dto;

import com.residenciasquad9.demo.domain.enums.TipoDepartamento;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoDTO {

    private String nome;
    private String descricao;
    private TipoDepartamento tipoDepartamento;
}
