package com.residenciasquad9.demo.domain.dto;

import com.residenciasquad9.demo.domain.enums.TipoCargo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public record CargoDTO() {
    private static TipoCargo TipoCargo;
}
