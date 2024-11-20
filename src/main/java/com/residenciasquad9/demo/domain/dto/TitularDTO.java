package com.residenciasquad9.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TitularDTO {

    private Integer idTitular;
    private String nome;
    private String cpf;
}
