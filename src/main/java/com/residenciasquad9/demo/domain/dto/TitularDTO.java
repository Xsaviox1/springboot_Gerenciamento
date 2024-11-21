package com.residenciasquad9.demo.domain.dto;

import lombok.Data;

@Data
public class TitularDTO {

    private String nome;
    private String cpf;
    private String email;

    // Atributo para associar um cliente
    private Long idCliente;
}