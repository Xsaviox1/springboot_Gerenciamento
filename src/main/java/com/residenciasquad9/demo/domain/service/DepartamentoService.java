package com.residenciasquad9.demo.domain.service;

import com.residenciasquad9.demo.domain.dto.DepartamentoDTO;
import com.residenciasquad9.demo.domain.entites.Departamento;

import java.util.List;
import java.util.Optional;

public interface DepartamentoService {

    // Método para salvar um departamento
    Departamento save(DepartamentoDTO departamentoDTO);

    // Método para encontrar um departamento por id
    Optional<Departamento> findById(Long id);

    // Método para buscar todos os departamentos
    List<Departamento> findAll();

    // Método para atualizar um departamento
    Departamento update(Long id, DepartamentoDTO departamentoDTO);

    // Método para excluir um departamento pelo id
    void deleteById(Long id);

    // Método para encontrar um departamento por nome
    Optional<Departamento> findByNome(String nome);
}

