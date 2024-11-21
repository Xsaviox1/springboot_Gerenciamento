package com.residenciasquad9.demo.domain.service;

import com.residenciasquad9.demo.domain.dto.ContaDTO;
import com.residenciasquad9.demo.domain.entites.Conta;

import java.util.Optional;

public interface ContaService {

    // Salvar conta
    Conta save(ContaDTO contaDTO);

    // Buscar conta por ID
    Optional<Conta> findById(int id);

    // Buscar conta por CPF
    Conta buscarContaPorCPF(String cpf);

    // Buscar conta por agência e número de conta
    Conta buscarContaPorAgenciaENumero(String agencia, String numeroConta);
}
