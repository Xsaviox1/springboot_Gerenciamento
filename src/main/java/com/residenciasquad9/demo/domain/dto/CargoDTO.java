package com.residenciasquad9.demo.domain.dto;

import com.residenciasquad9.demo.domain.enums.TipoCargo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoDTO {

    private Long idCargo;            // ID do cargo
    private TipoCargo tipoCargo;     // Tipo do cargo (Enum)
    private Long departamentoId;     // ID do Departamento (relacionamento com Departamento)
}

