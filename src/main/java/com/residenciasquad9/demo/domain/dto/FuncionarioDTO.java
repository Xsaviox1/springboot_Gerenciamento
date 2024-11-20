package com.residenciasquad9.demo.domain.dto;

import com.residenciasquad9.demo.domain.enums.Status;
import com.residenciasquad9.demo.domain.entites.Cargo;
import com.residenciasquad9.demo.domain.entites.Protocolo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {

    private String codigoFuncional;
    private String nome;
    private String email;
    private String departamento;
    private Status status;
    private Protocolo protocolo; // Se você precisar apenas dos dados de Protocolo
    private Cargo cargo; // Se você precisar apenas dos dados de Cargo

}
