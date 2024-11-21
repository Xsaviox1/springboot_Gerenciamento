package com.residenciasquad9.demo.domain.service;

import com.residenciasquad9.demo.domain.dto.FuncionarioDTO;
import com.residenciasquad9.demo.domain.entites.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {
    Funcionario save(FuncionarioDTO funcionarioDTO);

    Optional<Funcionario> findById(int id);

    List<Funcionario> findAll();

    Funcionario update(int id, FuncionarioDTO funcionarioDTO);

    void deleteById(int id);
}
