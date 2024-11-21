package com.residenciasquad9.demo.domain.service;

import com.residenciasquad9.demo.domain.dto.FuncionarioDTO;
import com.residenciasquad9.demo.domain.entites.Funcionario;

import java.util.Optional;

public interface FuncionarioService {

    // Método para criar um novo funcionário
    Funcionario criarFuncionario(FuncionarioDTO funcionarioDTO);

    // Método para atribuir um protocolo ao funcionário
    Funcionario atribuirProtocoloAoFuncionario(String cpf, String protocoloId);

    // Método para atribuir um cargo ao funcionário
    Funcionario atribuirCargoAoFuncionario(String cpf, Long cargoId);

    // Método para atribuir um departamento ao funcionário
    Funcionario atribuirDepartamentoAoFuncionario(String cpf, String departamento);

    // Método para buscar um funcionário por CPF
    Funcionario findById(String cpf);
}

